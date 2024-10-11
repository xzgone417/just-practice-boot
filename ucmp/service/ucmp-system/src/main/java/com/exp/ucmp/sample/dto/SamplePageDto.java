package com.exp.ucmp.sample.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.egrid.core.base.model.BaseModel;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class SamplePageDto  extends BaseModel {
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
    @XmlElement(name = "parameter")
    private SampleParameterDto dto;

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
    public SampleParameterDto getDto() {
        return dto;
    }
    public void setDto(SampleParameterDto dto) {
        this.dto = dto;
    }
    
    @Override
    public String toString() {
    	StringBuffer sb = new StringBuffer("PagingDto\n");
    	sb.append("-->").append("pageNum:").append(pageNum).append("\n");
    	sb.append("-->").append("pageSize:").append(pageSize).append("\n");
    	sb.append("-->").append("dto:").append(dto).append("\n");
		return sb.toString();
    }
    
	public static SamplePageDto getInstance() {
		SamplePageDto pageDto = new SamplePageDto();
		pageDto.setPageSize(10);
		pageDto.setPageNum(1);
		pageDto.setDto(SampleParameterDto.getInstance("参数一", "Param1", "1"));
		return pageDto;
	}
}
