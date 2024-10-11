package com.exp.ucmp.store.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


@ApiModel(value = "SysStoreAddDto", description = "门店信息集合信息")
public class SysStoreAddDto extends BaseModel {


    private static final long serialVersionUID = 1L;
    /**
     * 门店信息集合
     */
    @ApiModelProperty(value = "门店信息集合 ")
    private List<SysStoreInfoDto> sysStoreInfoDtoList;

    public List<SysStoreInfoDto> getSysStoreInfoDtoList() {
        return sysStoreInfoDtoList;
    }

    public void setSysStoreInfoDtoList(List<SysStoreInfoDto> sysStoreInfoDtoList) {
        this.sysStoreInfoDtoList = sysStoreInfoDtoList;
    }
}
