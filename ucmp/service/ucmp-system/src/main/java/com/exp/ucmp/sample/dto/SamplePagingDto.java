package com.exp.ucmp.sample.dto;

import java.util.ArrayList;
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
public class SamplePagingDto extends BaseModel {
    
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
    private List<SampleParameterDto> listParams;

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
    public List<SampleParameterDto> getListParams() {
        return listParams;
    }
    public void setListParams(List<SampleParameterDto> listParams) {
        this.listParams = listParams;
    }
    
    @Override
    public String toString() {
    	StringBuffer sb = new StringBuffer("PagingDto\n");
    	sb.append("-->").append("pageNum:").append(pageNum).append("\n");
    	sb.append("-->").append("pageSize:").append(pageSize).append("\n");
    	sb.append("-->").append("listParams:").append(listParams).append("\n");
		return sb.toString();
    }
    
    public static SamplePagingDto getInstance() {
    	List<SampleParameterDto> list = new ArrayList<>();
    	list.add(SampleParameterDto.getInstance("参数一", "Param1", "1"));
    	try {
			Thread.sleep(1 * 1000);
		} catch (InterruptedException e) {
		}
    	list.add(SampleParameterDto.getInstance("参数二", "Param2", "2"));
    	
    	SamplePagingDto pageDto = new SamplePagingDto();
		pageDto.setPageSize(10);
		pageDto.setPageNum(1);
		pageDto.setListParams(list);
		return pageDto;
    }
}
