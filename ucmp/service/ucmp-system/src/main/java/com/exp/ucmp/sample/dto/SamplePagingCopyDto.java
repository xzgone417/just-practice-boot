package com.exp.ucmp.sample.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.egrid.core.base.model.BaseModel;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class SamplePagingCopyDto  extends BaseModel {
    
    /**
     * <p>Field serialVersionUID: 序列化ID</p>
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * <p>Field pageNum: 页号</p>
     */
    private Integer pageNum;
    
    /**
     * <p>Field pageSize: 显示数量</p>
     */
    @XmlAttribute
    private Integer pageSize;
    
    /**
     * <p>Field dto: 封装dto</p>
     */
    @XmlElementWrapper(name = "parameters")
    @XmlElement(name = "parameter")
    private List<SampleParameterCopyDto> listDto;

    public SamplePagingCopyDto() {
    	
    }
    
    public Integer getPageNum() {
        return pageNum;
    }
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public List<SampleParameterCopyDto> getListDto() {
        return listDto;
    }
    public void setListDto(List<SampleParameterCopyDto> listDto) {
        this.listDto = listDto;
    }
    
    @Override
    public String toString() {
    	StringBuffer sb = new StringBuffer("PagingCopyDto\n");
    	sb.append("-->").append("pageNum:").append(pageNum).append("\n");
    	sb.append("-->").append("pageSize:").append(pageSize).append("\n");
    	sb.append("-->").append("listDto:").append(listDto).append("\n");
		return sb.toString();
    }
}
