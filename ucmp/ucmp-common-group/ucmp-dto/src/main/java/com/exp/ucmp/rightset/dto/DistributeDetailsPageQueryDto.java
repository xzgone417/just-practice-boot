package com.exp.ucmp.rightset.dto;

import com.exp.ucmp.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author hailele
 * @Description: 参与人数列表查询参数Dto
 * @date 2022/11/21 14:19
 */
@ApiModel(value = "DistributeDetailsPageQueryDto", description = "参与人数列表查询参数Dto")
public class DistributeDetailsPageQueryDto extends PageDto {

        /**
         * 权益包编号
         */
        @ApiModelProperty(value = "权益包编号")
        private String rightPackId;

        /**
         * 权益活动名称
         */
        @ApiModelProperty(value = "权益活动名称")
        private String campaignName;

        /**
        * 客户手机
        */
        @ApiModelProperty(value = "客户手机")

        private String customerIphone;

        public String getRightPackId() {
            return rightPackId;
        }

        public void setRightPackId(String rightPackId) {
            this.rightPackId = rightPackId;
        }

        public String getCampaignName() {
            return campaignName;
        }

        public void setCampaignName(String campaignName) {
            this.campaignName = campaignName;
        }

        public String getCustomerIphone() {
                return customerIphone;
            }

            public void setCustomerIphone(String customerIphone) {
                this.customerIphone = customerIphone;
            }
}
