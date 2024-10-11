package com.exp.ucmp.file.service.impl;

import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.*;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.file.dto.MaterialParamDto;
import com.exp.ucmp.file.service.FileService;
import com.exp.ucmp.model.Person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author GeYiJiang
 * @Description: 收购跟进实现
 * @date 2022/10/16 10:41
 */
@Service
@Transactional
public class FileServiceImpl implements FileService {
	
	 /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);
	
    @Autowired
    private ISysMaterialFileDao iSysMaterialFileDao;
    
    @Autowired
    private ISysConfigTopPicDao iSysConfigTopPicDao;
    
    @Autowired
    private ISysFileMsgDao iSysFileMsgDao;

    @Override
    @Transactional
    public Long savaMaterials(MaterialParamDto paramDto) {

        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        //写入文件底表
        SysFileMsgEntity sysFileMsgEntity = new SysFileMsgEntity();
        sysFileMsgEntity.generatePk();
        sysFileMsgEntity.setFilePath(paramDto.getObjKey());
        sysFileMsgEntity.setFileStatuss(Constants.fileStatus.used.value());
        sysFileMsgEntity.setFileName(paramDto.getOriginalFilename());
        sysFileMsgEntity.setFileType(paramDto.getContentType());
        sysFileMsgEntity.setCreatedBy(user.getPartyId());
        sysFileMsgEntity.setCreatedDate(new Date());
        sysFileMsgEntity.setUpdatedDate(new Date());
        sysFileMsgEntity.setUpdatedBy(user.getPartyId());
        LOGGER.info("======添加数据到文件信息表======"+JsonBeanUtil.beanToJson(sysFileMsgEntity));
        iSysFileMsgDao.insert(sysFileMsgEntity);

        //写入文件材料表
        SysMaterialFileEntity fileEntity = new SysMaterialFileEntity();
        fileEntity.generatePk();
        fileEntity.setFileId(sysFileMsgEntity.getFileId());
        fileEntity.setThumbnail(paramDto.getThumbnailFile());
        fileEntity.setMaterialOrder(paramDto.getMaterialOrder());
        fileEntity.setUploadPerson(user.getPartyId());
        fileEntity.setUploadDate(new Date());
        LOGGER.info("======添加数据到材料文件表======"+JsonBeanUtil.beanToJson(fileEntity));
        iSysMaterialFileDao.insert(fileEntity);

        return fileEntity.getMaterialFileId();
    }

	@Override
	public String getObjKey(Long fileId) {
		return this.iSysFileMsgDao.getObjKey(fileId);
	}

	@Override
	@Transactional
	public Long configTopPicUpload(MaterialParamDto paramDto, String carSeriesCode) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        //写入文件底表
        SysFileMsgEntity sysFileMsgEntity = new SysFileMsgEntity();
        sysFileMsgEntity.generatePk();
        sysFileMsgEntity.setFilePath(paramDto.getObjKey());
        sysFileMsgEntity.setFileStatuss(Constants.fileStatus.used.value());
        sysFileMsgEntity.setFileName(paramDto.getOriginalFilename());
        sysFileMsgEntity.setFileType(paramDto.getContentType());
        sysFileMsgEntity.setCreatedBy(user.getPartyId());
        sysFileMsgEntity.setCreatedDate(new Date());
        sysFileMsgEntity.setUpdatedDate(new Date());
        sysFileMsgEntity.setUpdatedBy(user.getPartyId());
        LOGGER.info("======configTopPicUpload添加数据到文件信息表======"+JsonBeanUtil.beanToJson(sysFileMsgEntity));
        iSysFileMsgDao.insert(sysFileMsgEntity);
        
        //写入配置表
        SysConfigTopPicEntity sysConfigTopPicEntity= new SysConfigTopPicEntity();
        sysConfigTopPicEntity.setCarSeriesCode(carSeriesCode);
        sysConfigTopPicEntity.setFileId(sysFileMsgEntity.getFileId());
        sysConfigTopPicEntity.setThumbnail(paramDto.getThumbnailFile());
        sysConfigTopPicEntity.setUploadDate(new Date());
        sysConfigTopPicEntity.setUploadPerson(user.getPartyId());
        this.iSysConfigTopPicDao.insert(sysConfigTopPicEntity);
		return sysFileMsgEntity.getFileId();
	}
}
