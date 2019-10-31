package com.ruoyi.music.domain;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 音乐题库 music_library
 *
 * @author echoyu
 * @date 2019-10-31
 */
@ApiModel("音乐题库")
public class MusicLibrary extends BaseEntity
        {
private static final long serialVersionUID=1L;

        /** 编号 */
            @ApiModelProperty("${comment}")
    private String id;

            /** 训练中心类型（训练中心1、模拟中心2） */
                                                        @Excel(name = "训练中心类型", readConverterExp = "训=练中心1、模拟中心2")
                        @ApiModelProperty("训练中心类型")
    private String ptype;

            /** 训练类型（试唱1、练耳2、乐理3） */
                                                        @Excel(name = "训练类型", readConverterExp = "试=唱1、练耳2、乐理3")
                        @ApiModelProperty("训练类型")
    private String type;

            /** 子类型（试唱：单音模唱、音程构唱、节奏试唱、旋律试唱 练耳、乐理：单音听辨、音程听辨、三和弦听辨、七和弦听辨、节奏视唱、旋律试唱 试唱、练耳、乐理：历年真题真练、板块模拟题库、阶段测试） */
                                                        @Excel(name = "子类型", readConverterExp = "试=唱：单音模唱、音程构唱、节奏试唱、旋律试唱,练=耳、乐理：单音听辨、音程听辨、三和弦听辨、七和弦听辨、节奏视唱、旋律试唱,试=唱、练耳、乐理：历年真题真练、板块模拟题库、阶段测试")
                        @ApiModelProperty("子类型")
    private String trainingType;

            /** 题目名称 */
                                                        @Excel(name = "题目名称")
                        @ApiModelProperty("题目名称")
    private String name;

            /** 单位：分钟 */
                                                        @Excel(name = "单位：分钟")
                        @ApiModelProperty("单位：分钟")
    private Long trainingTime;

                                /** 删除标志（0代表存在 2代表删除） */
            @ApiModelProperty("单位：分钟")
    private String delFlag;

            public void setId(String id)
            {
            this.id = id;
            }

    public String getId()
            {
            return id;
            }
            public void setPtype(String ptype)
            {
            this.ptype = ptype;
            }

    public String getPtype()
            {
            return ptype;
            }
            public void setType(String type)
            {
            this.type = type;
            }

    public String getType()
            {
            return type;
            }
            public void setTrainingType(String trainingType)
            {
            this.trainingType = trainingType;
            }

    public String getTrainingType()
            {
            return trainingType;
            }
            public void setName(String name)
            {
            this.name = name;
            }

    public String getName()
            {
            return name;
            }
            public void setTrainingTime(Long trainingTime)
            {
            this.trainingTime = trainingTime;
            }

    public Long getTrainingTime()
            {
            return trainingTime;
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
                .append("ptype",getPtype())
                .append("type",getType())
                .append("trainingType",getTrainingType())
                .append("name",getName())
                .append("trainingTime",getTrainingTime())
                .append("createBy",getCreateBy())
                .append("createTime",getCreateTime())
                .append("updateBy",getUpdateBy())
                .append("updateTime",getUpdateTime())
                .append("remark",getRemark())
                .append("delFlag",getDelFlag())
            .toString();
        }
        }
