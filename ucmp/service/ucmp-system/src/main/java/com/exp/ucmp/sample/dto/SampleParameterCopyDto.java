package com.exp.ucmp.sample.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.egrid.core.base.model.BaseModel;

@XmlRootElement
@XmlType(propOrder={"namezh", "nameen", "value", "createdBy", "createdDate"}) 
public class SampleParameterCopyDto extends BaseModel {
    /**
     * <p>Field serialVersionUID: 序列化ID</p>
     */
    private static final long serialVersionUID = 1L;
    /**
     * <p>Field namezh: 参数中文名称</p>
     */
    private String namezh;
    /**
     * <p>Field nameen: 参数英文名称</p>
     */
    private String nameen;
    /**
     * <p>Field value: 参数值</p>
     */
    private String value;
    
    private String createBy;
    
    private Date createDate;
    
    public SampleParameterCopyDto() {
    	
    }
    
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
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createdBy) {
		this.createBy = createdBy;
	}

	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createdDate) {
		this.createDate = createdDate;
	}

    @Override
    public String toString() {
    	StringBuffer sb = new StringBuffer("ParameterCopyDto\n");
    	sb.append("-->").append("namezh:").append(namezh).append("\n");
    	sb.append("-->").append("nameen:").append(nameen).append("\n");
    	sb.append("-->").append("value:").append(value).append("\n");
    	sb.append("-->").append("createdBy:").append(createBy).append("\n");
    	sb.append("-->").append("createdDate:").append(createDate).append("\n");
		return sb.toString();
    }
}
