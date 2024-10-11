package com.exp.ucmp.carDealer.service.impl;

import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.shiro.context.AuthContext;
import com.exp.ucmp.carDealer.service.FileUploadService;
import com.exp.ucmp.carDealer.service.HwObsService;
import com.exp.ucmp.carDealer.util.FileUtil;
import com.exp.ucmp.config.HwOBSConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.ISysFileMsgDao;
import com.exp.ucmp.entity.SysFileMsgEntity;
import com.exp.ucmp.file.dto.FileReturnDto;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.SysFileMsgPk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadServiceImpl.class);
    @Autowired
    private HwObsService hwObsService;
    @Autowired
    private ISysFileMsgDao sysFileMsgDao;


    @Override
    public FileReturnDto upload(MultipartFile file) throws IOException {
        Long materialFileId = RandomIDGennerator.get().generate();
        String objKey = HwOBSConfig.getObjectKey() + materialFileId.toString()+"-"+file.getOriginalFilename();
        //存入华为obs
        hwObsService.fileUpload(file,objKey);
        //压缩并转base64
        String compressToBASE64 = FileUtil.compressToBASE64(file);

        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        //写入文件底表
        Long fileId = RandomIDGennerator.get().generate();
        SysFileMsgEntity sysFileMsgEntity = new SysFileMsgEntity();
        sysFileMsgEntity.setFileId(fileId);
        sysFileMsgEntity.setFilePath(objKey);
        sysFileMsgEntity.setFileStatuss(Constants.fileStatus.used.value());
        sysFileMsgEntity.setFileName(file.getOriginalFilename());
        sysFileMsgEntity.setFileType(file.getContentType());
        sysFileMsgEntity.setCreatedBy(user.getPartyId());
        sysFileMsgEntity.setCreatedDate(new Date());
        sysFileMsgEntity.setUpdatedDate(new Date());
        sysFileMsgEntity.setUpdatedBy(user.getPartyId());
        sysFileMsgDao.insert(sysFileMsgEntity);

        return new FileReturnDto(fileId,compressToBASE64);
    }

    @Transactional
    @Override
    public void uploadFormwork(MultipartFile file, Long fileId) throws IOException {
        //先删除，再重新上传模板文件
        sysFileMsgDao.delete(new SysFileMsgPk(fileId));

        Long materialFileId = RandomIDGennerator.get().generate();
        String objKey = HwOBSConfig.getObjectKey() + materialFileId.toString()+"-"+file.getOriginalFilename();
        //存入华为obs
        hwObsService.fileUpload(file,objKey);
        //压缩并转base64

        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        //写入文件底表
        SysFileMsgEntity sysFileMsgEntity = new SysFileMsgEntity();
        sysFileMsgEntity.setFileId(fileId);
        sysFileMsgEntity.setFilePath(objKey);
        sysFileMsgEntity.setFileStatuss(Constants.fileStatus.used.value());
        sysFileMsgEntity.setFileName(file.getOriginalFilename());
        sysFileMsgEntity.setFileType(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
        sysFileMsgEntity.setCreatedBy(user.getPartyId());
        sysFileMsgEntity.setCreatedDate(new Date());
        sysFileMsgEntity.setUpdatedDate(new Date());
        sysFileMsgEntity.setUpdatedBy(user.getPartyId());
        sysFileMsgDao.insert(sysFileMsgEntity);

    }
}

