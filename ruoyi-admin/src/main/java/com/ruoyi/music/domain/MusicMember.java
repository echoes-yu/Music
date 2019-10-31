package com.ruoyi.music.domain;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 音乐会员 music_member
 *
 * @author echoyu
 * @date 2019-10-31
 */
@ApiModel("音乐会员")
public class MusicMember extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @ApiModelProperty("${comment}")
    private String id;

    /**
     * 登录名
     */
    @Excel(name = "登录名")
    @ApiModelProperty("登录名")
    private String username;

    /**
     * 昵称
     */
    @Excel(name = "昵称")
    @ApiModelProperty("昵称")
    private String nickname;

    /**
     * 头像
     */
    @Excel(name = "头像")
    @ApiModelProperty("头像")
    private String img;

    /**
     * 是否是会员
     */
    @Excel(name = "是否是会员")
    @ApiModelProperty("是否是会员")
    private String isMember;

    /**
     * 开通会员的日期
     */
    @Excel(name = "开通会员的日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("开通会员的日期")
    private Date memberTime;

    /**
     * 会员有效时长
     */
    @Excel(name = "会员有效时长")
    @ApiModelProperty("会员有效时长")
    private String memberValidNum;

    /**
     * 手机号
     */
    @Excel(name = "手机号")
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 微信名
     */
    @Excel(name = "微信名")
    @ApiModelProperty("微信名")
    private String weixinName;

    /**
     * 密码
     */
    @ApiModelProperty("微信名")
    private String password;

    /**
     * 角色编号（0 用户，2 后台管理员）
     */
    @ApiModelProperty("微信名")
    private String roleNo;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @ApiModelProperty("微信名")
    private String delFlag;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setIsMember(String isMember) {
        this.isMember = isMember;
    }

    public String getIsMember() {
        return isMember;
    }

    public void setMemberTime(Date memberTime) {
        this.memberTime = memberTime;
    }

    public Date getMemberTime() {
        return memberTime;
    }

    public void setMemberValidNum(String memberValidNum) {
        this.memberValidNum = memberValidNum;
    }

    public String getMemberValidNum() {
        return memberValidNum;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setWeixinName(String weixinName) {
        this.weixinName = weixinName;
    }

    public String getWeixinName() {
        return weixinName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    public String getRoleNo() {
        return roleNo;
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
                .append("username", getUsername())
                .append("nickname", getNickname())
                .append("img", getImg())
                .append("isMember", getIsMember())
                .append("memberTime", getMemberTime())
                .append("memberValidNum", getMemberValidNum())
                .append("phone", getPhone())
                .append("weixinName", getWeixinName())
                .append("password", getPassword())
                .append("roleNo", getRoleNo())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .toString();
    }
}
