package com.ruoyi.music.domain;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 评论列 music_comment
 *
 * @author linpq
 * @date 2019-10-31
 */
@ApiModel("评论列")
public class MusicComment extends TreeEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @ApiModelProperty("${comment}")
    private String id;

    /**
     * 上一级评论编号
     */
    @Excel(name = "上一级评论编号")
    @ApiModelProperty("上一级评论编号")
    private String pid;

    /**
     * 题目编号
     */
    @Excel(name = "题目编号")
    @ApiModelProperty("题目编号")
    private String itemId;

    /**
     * 评论者编号
     */
    @Excel(name = "评论者编号")
    @ApiModelProperty("评论者编号")
    private String userId;

    /**
     * 评论
     */
    @Excel(name = "评论")
    @ApiModelProperty("评论")
    private String comment;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @ApiModelProperty("评论")
    private String delFlag;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPid() {
        return pid;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
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
                .append("pid", getPid())
                .append("itemId", getItemId())
                .append("userId", getUserId())
                .append("comment", getComment())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("delFlag", getDelFlag())
                .toString();
    }
}
