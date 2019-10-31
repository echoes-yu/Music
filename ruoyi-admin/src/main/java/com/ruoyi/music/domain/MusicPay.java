package com.ruoyi.music.domain;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 支付信息 music_pay
 *
 * @author linpq
 * @date 2019-10-31
 */
@ApiModel("支付信息")
public class MusicPay extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @ApiModelProperty("编号")
    private String id;

    /**
     * 用户编号
     */
    @Excel(name = "用户编号")
    @ApiModelProperty("用户编号")
    private String userId;

    /**
     * 支付金额
     */
    @Excel(name = "支付金额")
    @ApiModelProperty("支付金额")
    private String payMoney;

    /**
     * 支付时间
     */
    @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("支付时间")
    private Date payTime;

    /**
     * 支付信息
     */
    @Excel(name = "支付信息")
    @ApiModelProperty("支付信息")
    private String payMsg;

    /**
     * 支付类型（1:微信 2：支付宝）
     */
    @Excel(name = "支付类型", readConverterExp = "1=:微信,2=：支付宝")
    @ApiModelProperty("支付类型")
    private String payType;

    /**
     * 订单流水号
     */
    @Excel(name = "订单流水号")
    @ApiModelProperty("订单流水号")
    private String orderId;

    /**
     * 会员有效时长
     */
    @Excel(name = "会员有效时长")
    @ApiModelProperty("会员有效时长")
    private Long memberValidNum;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @ApiModelProperty("会员有效时长")
    private String delFlag;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }

    public String getPayMoney() {
        return payMoney;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayMsg(String payMsg) {
        this.payMsg = payMsg;
    }

    public String getPayMsg() {
        return payMsg;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayType() {
        return payType;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setMemberValidNum(Long memberValidNum) {
        this.memberValidNum = memberValidNum;
    }

    public Long getMemberValidNum() {
        return memberValidNum;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("payMoney", getPayMoney())
                .append("payTime", getPayTime())
                .append("payMsg", getPayMsg())
                .append("payType", getPayType())
                .append("orderId", getOrderId())
                .append("memberValidNum", getMemberValidNum())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("delFlag", getDelFlag())
                .toString();
    }
}
