package com.ruoyi.music.domain;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学考咨询 music_consultation
 *
 * @author echoyu
 * @date 2019-10-31
 */
@ApiModel("学考咨询")
public class MusicConsultation extends BaseEntity
        {
private static final long serialVersionUID=1L;

        /** 编号 */
            @ApiModelProperty("${comment}")
    private String id;

            /** 标题 */
                                                        @Excel(name = "标题")
                        @ApiModelProperty("标题")
    private String title;

            /** 详情 */
                                                        @Excel(name = "详情")
                        @ApiModelProperty("详情")
    private String detail;

            /** 咨询类型 */
                                                        @Excel(name = "咨询类型")
                        @ApiModelProperty("咨询类型")
    private String type;

                                /** 删除标志（0代表存在 2代表删除） */
            @ApiModelProperty("咨询类型")
    private String delFlag;

            public void setId(String id)
            {
            this.id = id;
            }

    public String getId()
            {
            return id;
            }
            public void setTitle(String title)
            {
            this.title = title;
            }

    public String getTitle()
            {
            return title;
            }
            public void setDetail(String detail)
            {
            this.detail = detail;
            }

    public String getDetail()
            {
            return detail;
            }
            public void setType(String type)
            {
            this.type = type;
            }

    public String getType()
            {
            return type;
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
                .append("title",getTitle())
                .append("detail",getDetail())
                .append("type",getType())
                .append("createBy",getCreateBy())
                .append("createTime",getCreateTime())
                .append("updateBy",getUpdateBy())
                .append("updateTime",getUpdateTime())
                .append("remark",getRemark())
                .append("delFlag",getDelFlag())
            .toString();
        }
        }
