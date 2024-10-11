package com.exp.ucmp.sample.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.egrid.core.base.model.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@XmlRootElement
@XmlType(propOrder={"namezh", "nameen", "value", "createdBy", "createdDate"})
@ApiModel(value = "SampleParameterDto", description = "样例参数")
public class SampleParameterDto extends BaseModel {
    
    /**
     * <p>Field serialVersionUID: 序列化ID</p>
     */
    private static final long serialVersionUID = 1L;
    /**
     * <p>Field namezh: 参数中文名称</p>
     */
    @ApiModelProperty(value = "中文名称")
    private String namezh;
    /**
     * <p>Field nameen: 参数英文名称</p>
     */
    @ApiModelProperty(value = "英文名称")
    private String nameen;
    /**
     * <p>Field value: 参数值</p>
     */
    @ApiModelProperty(value = "参数值")
    private String value;
    
    @ApiModelProperty(value = "创建人")
    private String createdBy;
    
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    public String getNamezh() {
        return namezh;
    }
    public void setNamezh(String namezh) {
        this.namezh = namezh;
    }
    public String getNameen() {
        return nameen;
    }
    public void setNameen(String nameen) {
        this.nameen = nameen;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

    @Override
    public String toString() {
    	StringBuffer sb = new StringBuffer("ParameterDto\n");
    	sb.append("-->").append("namezh:").append(namezh).append("\n");
    	sb.append("-->").append("nameen:").append(nameen).append("\n");
    	sb.append("-->").append("value:").append(value).append("\n");
    	sb.append("-->").append("createdBy:").append(createdBy).append("\n");
    	sb.append("-->").append("createdDate:").append(createdDate).append("\n");
		return sb.toString();
    }
    
    public static SampleParameterDto getInstance(String nameZh, String nameEn, String value) {
    	SampleParameterDto parameterDto = new SampleParameterDto();
		parameterDto.setNamezh(nameZh);
		parameterDto.setNameen(nameEn);
		parameterDto.setValue(value);
		parameterDto.setCreatedBy("system");
		parameterDto.setCreatedDate(new Date());
		return parameterDto;
    }
}
