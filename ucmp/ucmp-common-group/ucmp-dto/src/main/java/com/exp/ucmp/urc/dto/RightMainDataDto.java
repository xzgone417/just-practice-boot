package com.exp.ucmp.urc.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RightMainDataDto", description = "权益主数据类")
public class RightMainDataDto {
	
	@ApiModelProperty(value = "权益ID")
	private String id;
	
	@ApiModelProperty(value = "权益状态 0-待启用/1-已启用/2-已停用")
    private int status;
	
	@ApiModelProperty(value = "权益名称")
    private String name;
	
	@ApiModelProperty(value = "显示名称")
    private String title;
	
	@ApiModelProperty(value = "权益图标")
    private String icon;
	
	@ApiModelProperty(value = "使用说明")
    private String terms;
	
	@ApiModelProperty(value = "权益类型名称,即服务内容名称")
    private String rightTypeName;
	
	@ApiModelProperty(value = "权益备注")
    private String memo;
	
	@ApiModelProperty(value = "展示分类名称")
    private String subtypeName;
	
	@ApiModelProperty(value = "发放类型名称")
    private String grantTypeName;
	
	@ApiModelProperty(value = "有效期限制 0-不限时，1-动态时间，2-区间时间")
    private int timeless;
	
	@ApiModelProperty(value = "生效后有效期：天")
    private String deadline;
	
	@ApiModelProperty(value = "计量 1-计量/0-不限量")
    private int countless;
	
	@ApiModelProperty(value = "计量上限")
    private String limited;
	
	@ApiModelProperty(value = "卡券池编号")
    private String coupon;
	
	@ApiModelProperty(value = "计量单位")
    private String unit;
	
	@ApiModelProperty(value = "权益对象 0-车辆/1-客户")
    private int target;
	
	@ApiModelProperty(value = "生效规则：0-立即生效/1-车辆激活")
	private int trigger;
	
	@ApiModelProperty(value = "是否支持兑换积分 0-否/1-是")
	private int convertible;
	
	@ApiModelProperty(value = "积分池编号")
    private String pool;
	
	@ApiModelProperty(value = "兑换积分数量")
    private String integral;
	
	@ApiModelProperty(value = "创建时间")
    private String createTime;
	
	@ApiModelProperty(value = "更新时间")
    private long updateTime;
	
	@ApiModelProperty(value = "卡券池名称")
    private String couponName;
	
	@ApiModelProperty(value = "积分池名称")
    private String poolName;
	
	@ApiModelProperty(value = "生效时间")
    private String effectTime;
	
	@ApiModelProperty(value = "失效时间")
    private String expireTime;
	
	@ApiModelProperty(value = "是否APP展示 0是1否")
    private int showable;
	
	@ApiModelProperty(value = "是否关联车型 0是1否")
    private int relatedModels;
	
	@ApiModelProperty(value = "工程车型代码")
    private String modelCode;
	
	@ApiModelProperty(value = "工程车型名称")
    private String modelName;
	
	@ApiModelProperty(value = "基本车型名称 如果为空那则选择的是全部")
    private String shapeName;
	
	@ApiModelProperty(value = "基本车型代码 如果为空那则选择的是全部")
    private String shapeCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public String getRightTypeName() {
		return rightTypeName;
	}

	public void setRightTypeName(String rightTypeName) {
		this.rightTypeName = rightTypeName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getSubtypeName() {
		return subtypeName;
	}

	public void setSubtypeName(String subtypeName) {
		this.subtypeName = subtypeName;
	}

	public String getGrantTypeName() {
		return grantTypeName;
	}

	public void setGrantTypeName(String grantTypeName) {
		this.grantTypeName = grantTypeName;
	}

	public int getTimeless() {
		return timeless;
	}

	public void setTimeless(int timeless) {
		this.timeless = timeless;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public int getCountless() {
		return countless;
	}

	public void setCountless(int countless) {
		this.countless = countless;
	}

	public String getLimited() {
		return limited;
	}

	public void setLimited(String limited) {
		this.limited = limited;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public int getTrigger() {
		return trigger;
	}

	public void setTrigger(int trigger) {
		this.trigger = trigger;
	}

	public String getPool() {
		return pool;
	}

	public void setPool(String pool) {
		this.pool = pool;
	}

	public String getIntegral() {
		return integral;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public String getPoolName() {
		return poolName;
	}

	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}

	public String getEffectTime() {
		return effectTime;
	}

	public void setEffectTime(String effectTime) {
		this.effectTime = effectTime;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

	public int getShowable() {
		return showable;
	}

	public void setShowable(int showable) {
		this.showable = showable;
	}

	public int getRelatedModels() {
		return relatedModels;
	}

	public void setRelatedModels(int relatedModels) {
		this.relatedModels = relatedModels;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getShapeName() {
		return shapeName;
	}

	public void setShapeName(String shapeName) {
		this.shapeName = shapeName;
	}

	public String getShapeCode() {
		return shapeCode;
	}

	public void setShapeCode(String shapeCode) {
		this.shapeCode = shapeCode;
	}
	
}
