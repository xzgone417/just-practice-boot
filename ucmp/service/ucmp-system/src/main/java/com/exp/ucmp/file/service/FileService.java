package com.exp.ucmp.file.service;

import com.exp.ucmp.file.dto.MaterialParamDto;

/**
 * @author GeYiJiang
 * @Description: 收购跟进
 * @date 2022/10/16 10:40
 */
public interface FileService {

    /**
     * 收购材料文件保存
     */
    Long savaMaterials(MaterialParamDto paramDto);

	String getObjKey(Long fileId);

	Long configTopPicUpload(MaterialParamDto paramDto, String carSeriesCode);
}
