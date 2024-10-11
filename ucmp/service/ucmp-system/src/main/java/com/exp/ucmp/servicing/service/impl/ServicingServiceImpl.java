package com.exp.ucmp.servicing.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.util.StringUtil;
import com.exp.ucmp.apig.isp.consumer.IspConsumer;
import com.exp.ucmp.carService.dto.QueryServiceDetailsDto;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.isp.dto.IspOrderAdditionalItemsDto;
import com.exp.ucmp.isp.dto.IspOrderCommonDto;
import com.exp.ucmp.isp.dto.IspOrderCommonReturnDto;
import com.exp.ucmp.isp.dto.IspOrderDetailReturnDto;
import com.exp.ucmp.isp.dto.IspOrderHistoryDto;
import com.exp.ucmp.isp.dto.IspOrderHistoryReturnDto;
import com.exp.ucmp.isp.dto.IspOrderMaintenanceItemsDto;
import com.exp.ucmp.isp.dto.IspOrderPartsDto;
import com.exp.ucmp.isp.dto.QueryOrderHistoryDto;
import com.exp.ucmp.isp.dto.QuoteApplyDto;
import com.exp.ucmp.isp.dto.QuoteApprovalDto;
import com.exp.ucmp.isp.dto.QuoteComponentAddDto;
import com.exp.ucmp.isp.dto.QuoteComponentDto;
import com.exp.ucmp.isp.dto.QuoteOrderAddDto;
import com.exp.ucmp.isp.dto.QuoteOrderDto;
import com.exp.ucmp.isp.dto.QuoteOtherFeesAddDto;
import com.exp.ucmp.isp.dto.QuoteOtherFeesDto;
import com.exp.ucmp.isp.dto.QuoteProjectAddDto;
import com.exp.ucmp.isp.dto.QuoteProjectDto;
import com.exp.ucmp.isp.dto.QuoteStatusDto;
import com.exp.ucmp.isp.dto.WorkOrderCommonQueryDto;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.servicing.dao.ServicingDao;
import com.exp.ucmp.servicing.dto.OrderAdditionalItemsDto;
import com.exp.ucmp.servicing.dto.OrderDetailDto;
import com.exp.ucmp.servicing.dto.OrderMaintenanceItemsDto;
import com.exp.ucmp.servicing.dto.OrderPartsDto;
import com.exp.ucmp.servicing.dto.QueryWorkOrderCommonDto;
import com.exp.ucmp.servicing.dto.QueryWorkOrderDto;
import com.exp.ucmp.servicing.dto.WorkOrderCommonDto;
import com.exp.ucmp.servicing.service.ServicingService;

import cn.hutool.core.collection.CollectionUtil;

@Service
public class ServicingServiceImpl implements ServicingService{
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ServicingServiceImpl.class);
    
    @Autowired
	private IspConsumer ispConsumer;
    
    @Autowired
    private ServicingDao servicingDao;

	@Override
	public String createServicing(QuoteApplyDto quoteApplyDto) throws Exception {
		//推送ISP
		Map<String, Object> params = new HashMap<>();
		params.put("ucmpOrderNo", quoteApplyDto.getUcmpOrderNo());
		params.put("siteType", quoteApplyDto.getSiteType());
		params.put("siteName", quoteApplyDto.getSiteName());
		params.put("siteCode", quoteApplyDto.getSiteCode());
		params.put("vin", quoteApplyDto.getVin());
		params.put("plateNo", quoteApplyDto.getPlateNo());
		params.put("creatorName", quoteApplyDto.getCreatorName());
		params.put("creatorEmpId", quoteApplyDto.getCreatorEmpId());
		params.put("expectDeliveryTime", quoteApplyDto.getExpectDeliveryTime());
		params.put("orderSource", quoteApplyDto.getOrderSource());
		params.put("remark", quoteApplyDto.getRemark());
		return this.ispConsumer.quoteApply(params);
	}

	@Override
	@Transactional
	public void acceptRepairProject(QuoteOrderDto dto) throws Exception {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		if(CollectionUtil.isEmpty(dto.getProjectList())){
			throw new Exception("报价单："+dto.getQuoteOrderNo()+"缺少维修项目");
		}
		//查询整备单是否存在
		QueryServiceDetailsDto detailsDto = this.servicingDao.findServiceDetails(dto.getUcmpOrderNo());
		if(detailsDto==null){
			throw new Exception("整备单："+dto.getUcmpOrderNo()+"不存在");
		}
		//报价单
		QuoteOrderAddDto addDto = new QuoteOrderAddDto();
		addDto.setQuoteOrderId(RandomIDGennerator.get().generate());
		addDto.setQuoteOrderNo(dto.getQuoteOrderNo());
		addDto.setUcmpOrderNo(dto.getUcmpOrderNo());
		addDto.setPlanCompleteDate(dto.getPlanCompleteDate());
		addDto.setCreatedBy(user.getPartyId());
		addDto.setUpdateBy(user.getPartyId());
		//维修项目
		List<QuoteProjectAddDto> projectAddList =new ArrayList<>();
		//维修配件
		List<QuoteComponentAddDto> componentAddList =new ArrayList<>();
		//其他费用
		List<QuoteOtherFeesAddDto> otherFeesAddList= new ArrayList<>();
		
		Double totalPrice=0.0;
		for (QuoteProjectDto project : dto.getProjectList()) {
			//工时费
			totalPrice+=project.getTimePrice();
			QuoteProjectAddDto projectAddDto = new QuoteProjectAddDto();
			projectAddDto.setQuoteOrderId(addDto.getQuoteOrderId());
			projectAddDto.setProjectId(RandomIDGennerator.get().generate());
			projectAddDto.setRepairProjectTypeCode(project.getRepairProjectTypeCode());
			projectAddDto.setRepairProjectType(project.getRepairProjectType());
			projectAddDto.setRepairProjectCode(project.getRepairProjectCode());
			projectAddDto.setRepairProject(project.getRepairProjectName());
			projectAddDto.setTimePrice(project.getTimePrice());
			projectAddDto.setDifferentiateCode(project.getDifferentiateCode());
			projectAddDto.setDifferentiate(project.getDifferentiate());
			projectAddDto.setIsComponent(1);
			projectAddDto.setIsOther(1);
			projectAddDto.setCreatedBy(user.getPartyId());
			projectAddDto.setUpdateBy(user.getPartyId());
			//零件费用
			if(CollectionUtil.isNotEmpty(project.getComponentList())){
				projectAddDto.setIsComponent(0);
				for (QuoteComponentDto component : project.getComponentList()) {
					totalPrice+=component.getComponentPrice();
					QuoteComponentAddDto componentAddDto = new QuoteComponentAddDto();
					componentAddDto.setComponentId(RandomIDGennerator.get().generate());
					componentAddDto.setProjectId(projectAddDto.getProjectId());
					componentAddDto.setComponentCode(component.getComponentCode());
					componentAddDto.setComponentName(component.getComponentName());
					componentAddDto.setComponentPrice(component.getComponentPrice());
					componentAddDto.setDifferentiateCode(component.getDifferentiateCode());
					componentAddDto.setDifferentiate(component.getDifferentiate());
					componentAddDto.setCreatedBy(user.getPartyId());
					componentAddDto.setUpdateBy(user.getPartyId());
					componentAddList.add(componentAddDto);
				}
			}
			//其他费用
			if(CollectionUtil.isNotEmpty(project.getOtherFeesList())){
				projectAddDto.setIsOther(0);
				for (QuoteOtherFeesDto other : project.getOtherFeesList()) {
					totalPrice+=Double.valueOf(other.getFees());
					QuoteOtherFeesAddDto otherFeesAddDto = new QuoteOtherFeesAddDto();
					otherFeesAddDto.setOtherFeesId(RandomIDGennerator.get().generate());
					otherFeesAddDto.setProjectId(projectAddDto.getProjectId());
					otherFeesAddDto.setRepairTimeCode(other.getRepairTimeCode());
					otherFeesAddDto.setRepairTimeName(other.getRepairTimeName());
					otherFeesAddDto.setOtherFeesCode(other.getOtherFeesCode());
					otherFeesAddDto.setOtherFeesName(other.getOtherFeesName());
					otherFeesAddDto.setFees(other.getFees());
					otherFeesAddDto.setDifferentiateCode(other.getDifferentiateCode());
					otherFeesAddDto.setDifferentiate(other.getDifferentiate());
					otherFeesAddDto.setReceivableAmount(other.getReceivableAmount());
					otherFeesAddDto.setRemark(other.getRemark());
					otherFeesAddDto.setCreatedBy(user.getPartyId());
					otherFeesAddDto.setUpdateBy(user.getPartyId());
					otherFeesAddList.add(otherFeesAddDto);
				}
			}
			projectAddList.add(projectAddDto);
		}
		addDto.setTotalPrice(totalPrice);
		//添加报价单
		this.servicingDao.addQuoteOrder(addDto);
		//添加维修项目
		this.servicingDao.addQuoteProject(projectAddList);
		//添加维修配件
		if(CollectionUtil.isNotEmpty(componentAddList)){
			this.servicingDao.addQuoteComponent(componentAddList);
		}
		//添加其他费用
		if(CollectionUtil.isNotEmpty(otherFeesAddList)){
			this.servicingDao.addQuoteOtherFees(otherFeesAddList);
		}
		String status;
		if(detailsDto.getServiceState().equals(Constants.SERVICE_STATE.WAIT_GENERATE.value())){
			status=Constants.SERVICE_STATE.WAIT_EXECUTE.value();
		}else if(detailsDto.getServiceState().equals(Constants.SERVICE_STATE.WAIT_FEEDBACK.value())){
			status=Constants.SERVICE_STATE.WAIT_APPROVAL.value();
		}else if(detailsDto.getServiceState().equals(Constants.SERVICE_STATE.REJECT.value())){
			status=detailsDto.getPreApprovalStatus();
		}else{
			throw new Exception("整备单："+dto.getUcmpOrderNo()+"处在不可报价状态");
		}
		//修改整备单状态
		this.servicingDao.updateServicingSatus(addDto.getQuoteOrderId(),status,addDto.getCreatedBy(),
				addDto.getUcmpOrderNo(),addDto.getPlanCompleteDate(),totalPrice,null);
	}

	@Override
	public void acceptRepairStatus(QuoteStatusDto dto) throws Exception {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		//查询整备单是否存在
		QueryServiceDetailsDto detailsDto = this.servicingDao.findServiceDetails(dto.getUcmpOrderNo());
		if(detailsDto==null){
			throw new Exception("整备单："+dto.getUcmpOrderNo()+"不存在");
		}
		if(dto.getStatus().equals(Constants.SERVICE_STATE.CANCEL.value())&&StringUtil.isEmpty(dto.getWorkOrderNo())){
			throw new Exception("反结算时工单号不能为空");
		}
		//修改整备单状态
		this.servicingDao.updateServicingSatus(null,dto.getStatus(),user.getPartyId(),
				dto.getUcmpOrderNo(),null,null,dto.getWorkOrderNo());
		//修改库存车辆状态
		if(dto.getStatus().equals(Constants.SERVICE_STATE.FINISH.value())){
			this.servicingDao.updateCarStockStatus(user.getPartyId(),Constants.STOCK_STATUS.WAIT_PUT.value(),detailsDto.getStockId());
		}
	}

	@Override
	public String quoteApproval(QuoteApprovalDto quoteApprovalDto) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("ucmpOrderNo", quoteApprovalDto.getUcmpOrderNo());
		params.put("remark", quoteApprovalDto.getRemark());
		params.put("approvalName", quoteApprovalDto.getApprovalName());
		params.put("approvalEmpId", quoteApprovalDto.getApprovalEmpId());
		params.put("status", quoteApprovalDto.getStatus());
		return ispConsumer.quoteApproval(params);
	}

	@Override
	public QueryWorkOrderDto workOrderHistory(QueryOrderHistoryDto queryOrderHistoryDto) throws Exception {
		QueryWorkOrderDto orderDto = new QueryWorkOrderDto();
		orderDto.setPageNum(queryOrderHistoryDto.getPageNum());
		orderDto.setPageSize(queryOrderHistoryDto.getPageSize());
		orderDto.setTotal(0);
		//二次筛选结果
		List<IspOrderHistoryDto> secondlist = new ArrayList<>();
		//从ISP查询该VIN所有选择的工单类型的维修数据
		Map<String, Object> params = new HashMap<>();
		params.put("vin", queryOrderHistoryDto.getVin());
		params.put("pageNum", 0);
		params.put("pageSize", 0);
		List<String> workOrderFlags= new ArrayList<>();
		if(queryOrderHistoryDto.getWorkOrderType() == 1){
			workOrderFlags.add("ISP");
			workOrderFlags.add("UC");
			workOrderFlags.add("B-APP");
		}else{
			workOrderFlags.add("UCMP");
		}
		params.put("workOrderFlags", workOrderFlags);
		String result = ispConsumer.workOrderHistory(params);
		IspOrderHistoryReturnDto returnDto = JsonBeanUtil.jsonToBean(result, IspOrderHistoryReturnDto.class);
		if(returnDto.getCode() != null && returnDto.getCode().equals(Constants.CodeEnum.eosCode.value()) && CollectionUtil.isNotEmpty(returnDto.getData().getList())){
			//如果页面传入了关键字，需进行筛选
			if(!StringUtil.isEmpty(queryOrderHistoryDto.getKeyword())){
				for (IspOrderHistoryDto fristDto : returnDto.getData().getList()) {
					if(fristDto.getMaintenanceName().contains(queryOrderHistoryDto.getKeyword())){
						secondlist.add(fristDto);
					}
				}
			}else{
				secondlist.addAll(returnDto.getData().getList());
			}
			LOGGER.info("二次筛选数据后有{}条数据",secondlist.size());
			//分页
			if(CollectionUtil.isEmpty(secondlist)){
				orderDto.setList(secondlist);
			}else{
				//去重
				if(queryOrderHistoryDto.getIsDuplicateRemoval()==0){
					secondlist = this.duplicateRemoval(secondlist);
				}
				//按照维修时间排序
				Collections.sort(secondlist, new Comparator<IspOrderHistoryDto>() {
				      @Override
				      public int compare(IspOrderHistoryDto o1,IspOrderHistoryDto o2) {
				    	  LOGGER.info("o1.getWorkOrderTime()="+o1.getWorkOrderTime());
				    	  LOGGER.info("o2.getWorkOrderTime()="+o2.getWorkOrderTime());
				    	  if(StringUtil.isEmpty(o1.getWorkOrderTime()) && !StringUtil.isEmpty(o2.getWorkOrderTime())){
					  			return 1;
					  		}
					    	if(!StringUtil.isEmpty(o1.getWorkOrderTime()) && StringUtil.isEmpty(o2.getWorkOrderTime())){
					  			return -1;
					  		}
					    	if(StringUtil.isEmpty(o1.getWorkOrderTime()) && StringUtil.isEmpty(o2.getWorkOrderTime())){
					  			return 0;
					  		}
				    	  if(Long.parseLong(o1.getWorkOrderTime()) > Long.parseLong(o2.getWorkOrderTime())){
				  			return 1;
				  		}
				  		if(Long.parseLong(o1.getWorkOrderTime()) < Long.parseLong(o2.getWorkOrderTime())){
				  			return -1;
				  		}
				  		return 0;
				      }
				    });
				//最终筛选结果
				List<IspOrderHistoryDto> returnlist = new ArrayList<>();
				Integer totalRecords = secondlist.size();
		    	Integer curPage=queryOrderHistoryDto.getPageNum();
		    	Integer pageSize=queryOrderHistoryDto.getPageSize();
		    	Integer totalPages=(totalRecords-1)/pageSize+1;
		    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    	if(curPage*pageSize>=totalRecords){
	    	  		for (int i = (curPage-1)*pageSize; i < totalRecords; i++) {
	    	  			if(!StringUtil.isEmpty(secondlist.get(i).getWorkOrderTime())){
	    	  				secondlist.get(i).setWorkOrderTimeStr(formatter.format(new Date(Long.valueOf(secondlist.get(i).getWorkOrderTime()))));
	    	  			}
	    	  			returnlist.add(secondlist.get(i));
	    	  		}
	    	  	}else{
	    	  		for (int i = (curPage-1)*pageSize; i < curPage*pageSize; i++) {
	    	  			if(!StringUtil.isEmpty(secondlist.get(i).getWorkOrderTime())){
	    	  				secondlist.get(i).setWorkOrderTimeStr(formatter.format(new Date(Long.valueOf(secondlist.get(i).getWorkOrderTime()))));
	    	  			}
	    	  			returnlist.add(secondlist.get(i));
	    	  		}
	    	  	}
		    	orderDto.setPages(totalPages);
		    	orderDto.setTotal(totalRecords);
		    	orderDto.setList(returnlist);
			}
		}
		return orderDto;
	}

	private List<IspOrderHistoryDto> duplicateRemoval(List<IspOrderHistoryDto> secondlist) {
		//先按维修时间倒序排
		Collections.sort(secondlist, new Comparator<IspOrderHistoryDto>() {
		      @Override
		      public int compare(IspOrderHistoryDto o1,IspOrderHistoryDto o2) {
		    	  LOGGER.info("o1.getWorkOrderTime()2="+o1.getWorkOrderTime());
		    	  LOGGER.info("o2.getWorkOrderTime()2="+o2.getWorkOrderTime());
		    	if(StringUtil.isEmpty(o1.getWorkOrderTime()) && !StringUtil.isEmpty(o2.getWorkOrderTime())){
		  			return 1;
		  		}
		    	if(!StringUtil.isEmpty(o1.getWorkOrderTime()) && StringUtil.isEmpty(o2.getWorkOrderTime())){
		  			return -1;
		  		}
		    	if(StringUtil.isEmpty(o1.getWorkOrderTime()) && StringUtil.isEmpty(o2.getWorkOrderTime())){
		  			return 0;
		  		}
		    	if(Long.valueOf(o1.getWorkOrderTime()) > Long.valueOf(o2.getWorkOrderTime())){
		  			return -1;
		  		}
		  		if(Long.valueOf(o1.getWorkOrderTime()) < Long.valueOf(o2.getWorkOrderTime())){
		  			return 1;
		  		}
		  		return 0;
		      }
		    });
		//去重
		Set<IspOrderHistoryDto> set = new TreeSet<>(new Comparator<IspOrderHistoryDto>() {
            @Override
            public int compare(IspOrderHistoryDto o1, IspOrderHistoryDto o2) {
                //字符串,则按照asicc码升序排列
            	return o1.getMaintenanceCode().compareTo(o2.getMaintenanceCode());
            }
        });
        set.addAll(secondlist);
        return new ArrayList<>(set);
	}

	@Override
	public QueryWorkOrderCommonDto workOrderQuery(WorkOrderCommonQueryDto workOrderCommonQueryDto) throws Exception {
		QueryWorkOrderCommonDto orderCommonDto = new QueryWorkOrderCommonDto();
		if(StringUtil.isEmpty(workOrderCommonQueryDto.getVin())){
			return orderCommonDto;
		}
		orderCommonDto.setPageNum(Integer.parseInt(workOrderCommonQueryDto.getPageNum()));
		orderCommonDto.setPageSize(Integer.parseInt(workOrderCommonQueryDto.getPageSize()));
		orderCommonDto.setTotal(0);
		//
		List<WorkOrderCommonDto> list = new ArrayList<>();
		//从ISP查询该VIN所有维修历史
		Map<String, Object> params = new HashMap<>();
		params.put("vin", workOrderCommonQueryDto.getVin());
		params.put("pageNum", 0);
		params.put("pageSize", 0);
		params.put("workOrderFlags", workOrderCommonQueryDto.getWorkOrderFlags());
		params.put("siteCode", workOrderCommonQueryDto.getSiteCode());
		params.put("orderTypes", workOrderCommonQueryDto.getOrderTypes());
		params.put("maintenanceTypes", workOrderCommonQueryDto.getMaintenanceTypes());
		params.put("workOrderNo", workOrderCommonQueryDto.getWorkOrderNo());
		String result = ispConsumer.workOrderQuery(params);
		IspOrderCommonReturnDto comReturnDto = JsonBeanUtil.jsonToBean(result, IspOrderCommonReturnDto.class);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if(comReturnDto.getCode() != null && comReturnDto.getCode().equals(Constants.CodeEnum.eosCode.value()) && 
				CollectionUtil.isNotEmpty(comReturnDto.getData().getList())){
			for (IspOrderCommonDto commonDto : comReturnDto.getData().getList()) {
				WorkOrderCommonDto dto=new WorkOrderCommonDto();
				dto.setCreateTime(commonDto.getDeliveryTime());
				if(dto.getCreateTime() != null){
					dto.setCreateTimeStr(formatter.format(new Date(dto.getCreateTime())));
				}
				dto.setWorkOrderNo(commonDto.getWorkOrderNo());
				dto.setInMileage(commonDto.getInMileage());
				dto.setLastMoney(commonDto.getPaidAmount());
				dto.setInnerCustomerCode(commonDto.getInnerCustomerCode());
				dto.setMaintenanceTypeLabel(commonDto.getMaintenanceTypeStr());
				list.add(dto);
			}
			Collections.sort(list, new Comparator<WorkOrderCommonDto>() {
			      @Override
			      public int compare(WorkOrderCommonDto o1,WorkOrderCommonDto o2) {
			    	  if(o1.getCreateTime()==null && o2.getCreateTime()!=null){
				  			return 1;
				  		}
				    	if(o1.getCreateTime()!=null && o2.getCreateTime()==null){
				  			return -1;
				  		}
				    	if(o1.getCreateTime()==null && o2.getCreateTime()==null){
				  			return 0;
				  		}
			    	  if(o1.getCreateTime() > o2.getCreateTime()){
			  			return -1;
			  		}
			  		if(o1.getCreateTime() < o2.getCreateTime()){
			  			return 1;
			  		}
			  		return 0;
			      }
			    });
			
			List<WorkOrderCommonDto> returnlist = new ArrayList<>();
			Integer totalRecords = list.size();
	    	Integer curPage=orderCommonDto.getPageNum();
	    	Integer pageSize=orderCommonDto.getPageSize();
	    	Integer totalPages=(totalRecords-1)/pageSize+1;
	    	if(curPage*pageSize>=totalRecords){
    	  		for (int i = (curPage-1)*pageSize; i < totalRecords; i++) {
    	  			returnlist.add(list.get(i));
    	  		}
    	  	}else{
    	  		for (int i = (curPage-1)*pageSize; i < curPage*pageSize; i++) {
    	  			returnlist.add(list.get(i));
    	  		}
    	  	}
	    	orderCommonDto.setPages(totalPages);
	    	orderCommonDto.setTotal(totalRecords);
	    	orderCommonDto.setList(returnlist);
		}
		return orderCommonDto;
	}

	@Override
	public OrderDetailDto workOrderQueryDetails(String workOrderNo) throws Exception {
		OrderDetailDto returnDto = new OrderDetailDto();
		//维修项目
		List<OrderMaintenanceItemsDto> maintenanceItems = new ArrayList<>();
		//维修配件
		List<OrderPartsDto> parts = new ArrayList<>();
		//其他费用
		List<OrderAdditionalItemsDto> additionalItems = new ArrayList<>();
		Double orderTotalPrice=null;//工单总价
		Double itemsTotalPrice=null;//项目总价
		Double partsTotalPrice=null;//配件总价
		Double addTotalPrice=null;//其他费用总价
		String result = ispConsumer.workOrderQueryDetail(workOrderNo);
		if(!StringUtil.isEmpty(result)){
			IspOrderDetailReturnDto detailDto = JsonBeanUtil.jsonToBean(result, IspOrderDetailReturnDto.class);
			if(detailDto.getCode() != null && detailDto.getCode().equals(Constants.CodeEnum.eosCode.value())&&detailDto.getData()!=null){
				orderTotalPrice=0.0;
				//维修项目
				if(CollectionUtil.isNotEmpty(detailDto.getData().getMaintenanceItems())){
					itemsTotalPrice=0.0;
					for (IspOrderMaintenanceItemsDto itemsDto : detailDto.getData().getMaintenanceItems()) {
						OrderMaintenanceItemsDto dto = new OrderMaintenanceItemsDto();
						dto.setCode(itemsDto.getCode());
						dto.setName(itemsDto.getName());
						dto.setStdTime(itemsDto.getStdTime());
						dto.setManHour(itemsDto.getManHour());
						dto.setManHourFee(itemsDto.getManHourFee());
						dto.setTotalPrice(itemsDto.getManHourFee());
						dto.setReceivePrice(itemsDto.getReceivePrice());
						maintenanceItems.add(dto);
						itemsTotalPrice+=dto.getReceivePrice();
					}
					orderTotalPrice+=itemsTotalPrice;
				}
				//维修配件
				if(CollectionUtil.isNotEmpty(detailDto.getData().getParts())){
					partsTotalPrice=0.0;
					for (IspOrderPartsDto itemsDto : detailDto.getData().getParts()) {
						OrderPartsDto dto = new OrderPartsDto();
						dto.setSpCode(itemsDto.getSpCode());
						dto.setSpName(itemsDto.getSpName());
						dto.setSalePrice(itemsDto.getSalePrice());
						dto.setAmount(itemsDto.getAmount());
						dto.setTotalPrice(itemsDto.getTotalPrice());
						dto.setReceivePrice(itemsDto.getReceivePrice());
						parts.add(dto);
						partsTotalPrice+=dto.getReceivePrice();
					}
					orderTotalPrice+=partsTotalPrice;
				}
				//其他费用
				if(CollectionUtil.isNotEmpty(detailDto.getData().getAdditionalItems())){
					addTotalPrice=0.0;
					for (IspOrderAdditionalItemsDto itemsDto : detailDto.getData().getAdditionalItems()) {
						OrderAdditionalItemsDto dto = new OrderAdditionalItemsDto();
						dto.setCode(itemsDto.getCode());
						dto.setName(itemsDto.getName());
						dto.setTotalPrice(itemsDto.getTotalPrice());
						dto.setReceivePrice(itemsDto.getReceivePrice());
						additionalItems.add(dto);
						addTotalPrice+=dto.getReceivePrice();
					}
					orderTotalPrice+=addTotalPrice;
				}
				
			}
		}
		returnDto.setMaintenanceItems(maintenanceItems);
		returnDto.setParts(parts);
		returnDto.setAdditionalItems(additionalItems);
		returnDto.setOrderTotalPrice(orderTotalPrice);
		returnDto.setItemsTotalPrice(itemsTotalPrice);
		returnDto.setPartsTotalPrice(partsTotalPrice);
		returnDto.setAddTotalPrice(addTotalPrice);
		return returnDto;
	}

}
