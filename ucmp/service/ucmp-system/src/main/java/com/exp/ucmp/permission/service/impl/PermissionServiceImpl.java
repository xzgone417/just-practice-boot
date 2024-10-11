/**
 * 
 * 初米网络 Copyright (C) 2018 Egridcloud, Inc, All rights reserved.
 */
package com.exp.ucmp.permission.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egrid.core.copiers.Copiers;
import com.egrid.core.util.StringUtil;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.IApplicationInfoDao;
import com.exp.ucmp.dao.IMenuInfoDao;
import com.exp.ucmp.dao.IOperationInfoDao;
import com.exp.ucmp.dao.IPermissionInfoDao;
import com.exp.ucmp.dao.IResourceIdentifierDao;
import com.exp.ucmp.dao.IResourceInfoDao;
import com.exp.ucmp.entity.ApplicationInfoEntity;
import com.exp.ucmp.entity.MenuInfoEntity;
import com.exp.ucmp.entity.OperationInfoEntity;
import com.exp.ucmp.entity.PermissionInfoEntity;
import com.exp.ucmp.entity.ResourceIdentifierEntity;
import com.exp.ucmp.entity.ResourceInfoEntity;
import com.exp.ucmp.exception.IllegalParameterException;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.permission.dao.IPermissionDao;
import com.exp.ucmp.permission.dto.ApplicationInfoDto;
import com.exp.ucmp.permission.dto.BatchMenuUrlDto;
import com.exp.ucmp.permission.dto.BatchPermissionUrlDto;
import com.exp.ucmp.permission.dto.MenuUrlDto;
import com.exp.ucmp.permission.dto.PermissionUrlDto;
import com.exp.ucmp.permission.service.PermissionService;
import com.egrid.core.shiro.context.AuthContext;

/**
 * @author Yiyongfei
 * @date 2022年07月12日
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private IApplicationInfoDao applicationInfoDao;
    @Autowired
    private IOperationInfoDao operationInfoDao;
    @Autowired
    private IResourceInfoDao resourceInfoDao;
    @Autowired
    private IPermissionInfoDao permissionInfoDao;
    @Autowired
    private IResourceIdentifierDao resourceIdentifierDao;
    @Autowired
    private IPermissionDao permissionDao;
    @Autowired
    private IMenuInfoDao menuInfoDao;

    /**
     * 添加应用（用于生成权限数据）
     * 
     * @param applicationInfoDto
     */
    @Override
    public void addApplication(ApplicationInfoDto applicationInfoDto) {
        /*检查系统是否存在*/
        ApplicationInfoEntity applicationInfoEntity = new ApplicationInfoEntity();
        applicationInfoEntity.setApplicationName(applicationInfoDto.getApplicationName());
        int count = applicationInfoDao.selectBySelectiveCount(applicationInfoEntity);
        try {
            if (count > 0) {
                throw new IllegalParameterException("应用(" + applicationInfoDto.getApplicationName() + ")已存在，不能新增!");
            } else {
                applicationInfoEntity =
                    Copiers.beanToBean(applicationInfoDto, ApplicationInfoDto.class, ApplicationInfoEntity.class);
                applicationInfoEntity.generatePk();
                applicationInfoEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                applicationInfoEntity.setUpdatedBy(applicationInfoEntity.getCreatedBy());
                applicationInfoDao.insert(applicationInfoEntity);
            }
        } finally {
            applicationInfoEntity = null;
        }
    }

    /**
     * 
     * 添加权限（用于生成权限数据）
     * 
     * @param batchPermissionUrlDto
     * 
     */
    @Override
    public void batchAddPermission(BatchPermissionUrlDto batchPermissionUrlDto) {
        for (PermissionUrlDto permissionUrlDto : batchPermissionUrlDto.getListPermissionUrl()) {
            String application =
                permissionUrlDto.getPermission().substring(0, permissionUrlDto.getPermission().indexOf(":"));
            String resource = permissionUrlDto.getPermission().substring(
                permissionUrlDto.getPermission().indexOf(":") + 1, permissionUrlDto.getPermission().lastIndexOf(":"));
            String operation =
                permissionUrlDto.getPermission().substring(permissionUrlDto.getPermission().lastIndexOf(":") + 1);
            OperationInfoEntity operationInfoEntity = getOperation(operation);
            ApplicationInfoEntity applicationInfoEntity = getApplication(application);
            ResourceInfoEntity resourceInfoEntity =
                getResource(applicationInfoEntity.getApplicationId(), application, resource);
            PermissionInfoEntity permissionInfoEntity = getPermission(permissionUrlDto.getName(),
                resourceInfoEntity.getResourceId(), operationInfoEntity.getOperationId());
            getResourceIdentifier(permissionUrlDto.getUrl(),
                permissionUrlDto.getName(), permissionUrlDto.getAccessType(), permissionInfoEntity.getPermissionId());
        }
    }

    /**
     * 获取应用信息
     * 
     * @param applicationName
     * @return
     */
    private ApplicationInfoEntity getApplication(String applicationName) {
        ApplicationInfoEntity applicationInfoEntity = new ApplicationInfoEntity();
        applicationInfoEntity.setApplicationName(applicationName);
        List<ApplicationInfoEntity> list = applicationInfoDao.selectBySelective(applicationInfoEntity);
        try {
            return list.get(0);
        } finally {
            applicationInfoEntity = null;
            list = null;
        }
    }

    /**
     * 获取操作信息
     * 
     * @param operationName
     * @return
     */
    private OperationInfoEntity getOperation(String operationName) {
        OperationInfoEntity operationInfoEntity = new OperationInfoEntity();
        operationInfoEntity.setOperationName(operationName);
        List<OperationInfoEntity> list = operationInfoDao.selectBySelective(operationInfoEntity);
        try {
            return list.get(0);
        } finally {
            operationInfoEntity = null;
            list = null;
        }
    }

    /**
     * 获取资源信息
     * 
     * @param applicationId
     * @param applicationName
     * @param resourceName
     * @return
     */
    private ResourceInfoEntity getResource(Long applicationId, String applicationName, String resourceName) {
        ResourceInfoEntity resourceInfoEntity = new ResourceInfoEntity();
        resourceInfoEntity.setResourceContent(applicationName + ":" + resourceName);
        List<ResourceInfoEntity> list = resourceInfoDao.selectBySelective(resourceInfoEntity);
        try {
            if (list.size() > 0) {
                return list.get(0);
            } else {
                if (resourceName.indexOf(":") > 0) {
                    ResourceInfoEntity parentResourceEntity = getResource(applicationId, applicationName,
                        resourceName.substring(0, resourceName.lastIndexOf(":")));
                    resourceInfoEntity = new ResourceInfoEntity();
                    resourceInfoEntity.generatePk();
                    resourceInfoEntity.setApplicationId(applicationId);
                    resourceInfoEntity.setParentResourceId(parentResourceEntity.getResourceId());
                    resourceInfoEntity.setResourceName(resourceName.substring(resourceName.lastIndexOf(":") + 1));
                    resourceInfoEntity.setResourceContent(parentResourceEntity.getResourceContent() + ":"
                        + resourceName.substring(resourceName.lastIndexOf(":") + 1));
                    resourceInfoEntity.setResourceDesc(resourceName);
                    resourceInfoEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                    resourceInfoEntity.setUpdatedBy(resourceInfoEntity.getCreatedBy());
                    resourceInfoDao.insert(resourceInfoEntity);
                    return resourceInfoEntity;
                } else {
                    resourceInfoEntity = new ResourceInfoEntity();
                    resourceInfoEntity.generatePk();
                    resourceInfoEntity.setApplicationId(applicationId);
                    resourceInfoEntity.setParentResourceId(null);
                    resourceInfoEntity.setResourceName(resourceName);
                    resourceInfoEntity.setResourceContent(applicationName + ":" + resourceName);
                    resourceInfoEntity.setResourceDesc(resourceName);
                    resourceInfoEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                    resourceInfoEntity.setUpdatedBy(resourceInfoEntity.getCreatedBy());
                    resourceInfoDao.insert(resourceInfoEntity);
                    return resourceInfoEntity;
                }
            }
        } finally {
            resourceInfoEntity = null;
            list = null;
        }
    }

    /**
     * 获取权限信息
     * 
     * @param permissionName
     * @param resourceId
     * @param operationId
     * @return
     */
    private PermissionInfoEntity getPermission(String permissionName, Long resourceId, Long operationId) {
        PermissionInfoEntity permissionInfoEntity = new PermissionInfoEntity();
        permissionInfoEntity.setResourceId(resourceId);
        permissionInfoEntity.setOperationId(operationId);
        List<PermissionInfoEntity> list = permissionInfoDao.selectBySelective(permissionInfoEntity);
        try {
            if (list.size() > 0) {
                return list.get(0);
            } else {
                permissionInfoEntity = new PermissionInfoEntity();
                permissionInfoEntity.generatePk();
                permissionInfoEntity.setResourceId(resourceId);
                permissionInfoEntity.setOperationId(operationId);
                permissionInfoEntity.setPermissionName(permissionName);
                permissionInfoEntity.setPermissionDesc(permissionName);
                permissionInfoEntity.setIsValid("01");
                permissionInfoEntity.setIsDelete("01");
                permissionInfoEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                permissionInfoEntity.setUpdatedBy(permissionInfoEntity.getCreatedBy());
                permissionInfoDao.insert(permissionInfoEntity);
                return permissionInfoEntity;
            }
        } finally {
            permissionInfoEntity = null;
            list = null;
        }
    }

    /**
     * 获取资源标识信息
     * 
     * @param permissionName
     * @param resourceId
     * @param operationId
     * @return
     */
    private ResourceIdentifierEntity getResourceIdentifier(String url, String identifierName, String accessType,
        Long permissionId) {
        ResourceIdentifierEntity resourceIdentifierEntity = new ResourceIdentifierEntity();
        resourceIdentifierEntity.setIdentifierPath(url);
        resourceIdentifierEntity.setPermissionId(permissionId);
        List<ResourceIdentifierEntity> list = permissionDao.selectByPermissionOrUrl(resourceIdentifierEntity);
        try {
            if (list.size() > 0) {
                ResourceIdentifierEntity entity = list.get(0);
                entity.setIdentifierPath(url);
                if (Constants.ResouceAccessType.AUTHZ.value().equals(accessType)) {
                    entity.setPermissionId(permissionId);
                } else {
                    entity.setPermissionId(null);
                }
                resourceIdentifierDao.update(entity);
                return entity;
            } else {
                resourceIdentifierEntity = new ResourceIdentifierEntity();
                resourceIdentifierEntity.generatePk();
                if (Constants.ResouceAccessType.AUTHZ.value().equals(accessType)) {
                    resourceIdentifierEntity.setPermissionId(permissionId);
                }
                resourceIdentifierEntity.setIdentifierName(identifierName);
                resourceIdentifierEntity.setIdentifierPath(url);
                resourceIdentifierEntity.setIdentifierType("01");
                resourceIdentifierEntity.setAccessType(accessType);
                resourceIdentifierEntity.setIsValid("01");
                resourceIdentifierEntity.setIsDelete("01");
                resourceIdentifierEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                resourceIdentifierEntity.setUpdatedBy(resourceIdentifierEntity.getCreatedBy());
                resourceIdentifierDao.insert(resourceIdentifierEntity);
                return resourceIdentifierEntity;
            }
        } finally {
            resourceIdentifierEntity = null;
            list = null;
        }
    }

    /**
     * 添加菜单（用于生成权限数据）
     * 
     * @param batchPermissionUrlDto
     */
    @Override
    public void batchAddMenu(BatchMenuUrlDto batchMenuUrlDto) {
        for (MenuUrlDto menuUrlDto : batchMenuUrlDto.getListMenuUrl()) {
            String tmpMenu = null;
            String tmpParentMenu = null;
            if (menuUrlDto.getMenu().indexOf(":") > 0) {
                tmpMenu = menuUrlDto.getMenu().substring(menuUrlDto.getMenu().lastIndexOf(":") + 1);
                tmpParentMenu = menuUrlDto.getMenu().substring(0, menuUrlDto.getMenu().lastIndexOf(":"));
            } else {
                tmpMenu = menuUrlDto.getMenu();
            }
            getMenu(tmpMenu, tmpParentMenu, menuUrlDto.getUrl(), menuUrlDto.getSeq(), menuUrlDto.getUpdate());
        }
    }

    private MenuInfoEntity getMenu(String menu, String parentMenu, String url, Integer seq, boolean update) {
        MenuInfoEntity menuInfoEntity = new MenuInfoEntity();
        menuInfoEntity.setMenuName(menu);
        List<MenuInfoEntity> list = menuInfoDao.selectBySelective(menuInfoEntity);
        try {
            ResourceIdentifierEntity tmpEntity = null;
            if (!StringUtil.isEmpty(url)) {
                tmpEntity = getResourceIdentifier(url);
            }
            if (list.size() > 0 && (tmpEntity == null || list.get(0).getIdentifierId() == null || tmpEntity.getIdentifierId().longValue() == list.get(0).getIdentifierId().longValue() || (tmpEntity.getIdentifierId().longValue() != list.get(0).getIdentifierId().longValue() && update))) {
                if (StringUtil.isEmpty(url) && seq == null) {
                    return list.get(0);
                } else {
                    MenuInfoEntity entity = list.get(0);
                    if (tmpEntity != null) {
                        entity.setIdentifierId(tmpEntity != null ? tmpEntity.getIdentifierId() : null);
                    }
                    if (seq != null) {
                        entity.setMenuSequence(seq);
                    }
                    menuInfoDao.update(entity);
                    return entity;
                }
            } else {
                if (!StringUtil.isEmpty(parentMenu)) {
                    String tmpMenu = null;
                    String tmpParentMenu = null;
                    if (parentMenu.indexOf(":") > 0) {
                        tmpMenu = parentMenu.substring(parentMenu.lastIndexOf(":") + 1);
                        tmpParentMenu = parentMenu.substring(0, parentMenu.lastIndexOf(":"));
                    } else {
                        tmpMenu = parentMenu;
                    }
                    MenuInfoEntity parentMenuInfoEntity = getMenu(tmpMenu, tmpParentMenu, null, null, update);
                    menuInfoEntity = new MenuInfoEntity();
                    menuInfoEntity.generatePk();
                    menuInfoEntity.setParentMenuId(parentMenuInfoEntity.getMenuId());
                    menuInfoEntity.setMenuName(menu);
                    if (StringUtil.isEmpty(url)) {
                        menuInfoEntity.setIdentifierId(null);
                    } else {
                        ResourceIdentifierEntity entity = getResourceIdentifier(url);
                        menuInfoEntity.setIdentifierId(entity != null ? entity.getIdentifierId() : null);
                    }
                    if (seq == null) {
                        MenuInfoEntity entity = new MenuInfoEntity();
                        entity.setParentMenuId(parentMenuInfoEntity.getMenuId());
                        Integer menuSeq = permissionDao.selectMenuSeqenceByParent(entity);
                        menuInfoEntity.setMenuSequence(menuSeq != null ? menuSeq : 1);
                    } else {
                        menuInfoEntity.setMenuSequence(seq);
                    }
                    menuInfoEntity.setIsValid("01");
                    menuInfoEntity.setIsDelete("01");
                    menuInfoEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                    menuInfoEntity.setUpdatedBy(menuInfoEntity.getCreatedBy());
                    menuInfoDao.insert(menuInfoEntity);
                    return menuInfoEntity;
                } else {
                    menuInfoEntity = new MenuInfoEntity();
                    menuInfoEntity.generatePk();
                    menuInfoEntity.setParentMenuId(null);
                    menuInfoEntity.setMenuName(menu);
                    if (StringUtil.isEmpty(url)) {
                        menuInfoEntity.setIdentifierId(null);
                    } else {
                        ResourceIdentifierEntity entity = getResourceIdentifier(url);
                        menuInfoEntity.setIdentifierId(entity != null ? entity.getIdentifierId() : null);
                    }
                    if (seq == null) {
                        Integer menuSeq = permissionDao.selectMenuSeqenceByParent(new MenuInfoEntity());
                        menuInfoEntity.setMenuSequence(menuSeq != null ? menuSeq : 1);
                    } else {
                        menuInfoEntity.setMenuSequence(seq);
                    }
                    menuInfoEntity.setIsValid("01");
                    menuInfoEntity.setIsDelete("01");
                    menuInfoEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                    menuInfoEntity.setUpdatedBy(menuInfoEntity.getCreatedBy());
                    menuInfoDao.insert(menuInfoEntity);
                    return menuInfoEntity;
                }
            }
        } finally {
            menuInfoEntity = null;
            list = null;
        }
    }

    private ResourceIdentifierEntity getResourceIdentifier(String url) {
        ResourceIdentifierEntity resourceIdentifierEntity = new ResourceIdentifierEntity();
        resourceIdentifierEntity.setIdentifierPath(url);
        List<ResourceIdentifierEntity> list = permissionDao.selectByPermissionOrUrl(resourceIdentifierEntity);
        try {
            if (list.size() > 0) {
                return list.get(0);
            } else {
                return null;
            }
        } finally {
            resourceIdentifierEntity = null;
            list = null;
        }
    }
}
