package com.ruoyi.music.domain;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 成员学习记录 music_studying
 *
 * @author echoyu
 * @date 2019-10-31
 */
@ApiModel("成员学习记录")
public class MusicStudying extends BaseEntity
        {
private static final long serialVersionUID=1L;

        /** 学习记录编号 */
            @ApiModelProperty("${comment}")
    private String id;

            /** 题目编号 */
                                                        @Excel(name = "题目编号")
                        @ApiModelProperty("题目编号")
    private String itemId;

            /** 用户编号 */
                                                        @Excel(name = "用户编号")
                        @ApiModelProperty("用户编号")
    private String userId;

            /** 是否收入错题本（0否 1是） */
                                                        @Excel(name = "是否收入错题本", readConverterExp = "0=否,1=是")
                        @ApiModelProperty("是否收入错题本")
    private Integer isCollection;

                                /** 删除标志（0代表存在 2代表删除） */
            @ApiModelProperty("是否收入错题本")
    private String delFlag;

            public void setId(String id)
            {
            this.id = id;
            }

    public String getId()
            {
            return id;
            }
            public void setItemId(String itemId)
            {
            this.itemId = itemId;
            }

    public String getItemId()
            {
            return itemId;
            }
            public void setUserId(String userId)
            {
            this.userId = userId;
            }

    public String getUserId()
            {
            return userId;
            }
            public void setIsCollection(Integer isCollection)
            {
            this.isCollection = isCollection;
            }

    public Integer getIsCollection()
            {
            return isCollection;
            }
                                public void setDelFlag(String delFlag)
            {
            this.delFlag = delFlag;
            }

    public String getDelFlag()
            {
            return delFlag;
            }
    
@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id",getId())
                .append("itemId",getItemId())
                .append("userId",getUserId())
                .append("isCollection",getIsCollection())
                .append("createBy",getCreateBy())
                .append("createTime",getCreateTime())
                .append("updateBy",getUpdateBy())
                .append("updateTime",getUpdateTime())
                .append("remark",getRemark())
                .append("delFlag",getDelFlag())
            .toString();
        }
        }
