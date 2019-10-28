package com.ruoyi.music.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 音乐试题对象 music_item
 * 
 * @author linpq
 * @date 2019-10-27
 */
public class MusicItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    /** 题库编号 */
    @Excel(name = "题库编号")
    private String pid;

    /** 试题编号 */
    @Excel(name = "试题编号")
    private Long itemNo;

    /** 声音性别 */
    @Excel(name = "声音性别")
    private String voiceSex;

    /** 题目名称 */
    @Excel(name = "题目名称")
    private String itemName;

    /** 音频 */
    @Excel(name = "音频")
    private String voice;

    /** 音谱图 */
    @Excel(name = "音谱图")
    private String voiceImg;

    /** 答案 */
    @Excel(name = "答案")
    private String solution;

    /** 答案解析 */
    @Excel(name = "答案解析")
    private String solutionAnalysis;

    /** 答案A */
    @Excel(name = "答案A")
    private String answerA;

    /** 答案B */
    @Excel(name = "答案B")
    private String answerB;

    /** 答案C */
    @Excel(name = "答案C")
    private String answerC;

    /** 答案D */
    @Excel(name = "答案D")
    private String answerD;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setPid(String pid) 
    {
        this.pid = pid;
    }

    public String getPid() 
    {
        return pid;
    }
    public void setItemNo(Long itemNo) 
    {
        this.itemNo = itemNo;
    }

    public Long getItemNo() 
    {
        return itemNo;
    }
    public void setVoiceSex(String voiceSex) 
    {
        this.voiceSex = voiceSex;
    }

    public String getVoiceSex() 
    {
        return voiceSex;
    }
    public void setItemName(String itemName) 
    {
        this.itemName = itemName;
    }

    public String getItemName() 
    {
        return itemName;
    }
    public void setVoice(String voice) 
    {
        this.voice = voice;
    }

    public String getVoice() 
    {
        return voice;
    }
    public void setVoiceImg(String voiceImg) 
    {
        this.voiceImg = voiceImg;
    }

    public String getVoiceImg() 
    {
        return voiceImg;
    }
    public void setSolution(String solution) 
    {
        this.solution = solution;
    }

    public String getSolution() 
    {
        return solution;
    }
    public void setSolutionAnalysis(String solutionAnalysis) 
    {
        this.solutionAnalysis = solutionAnalysis;
    }

    public String getSolutionAnalysis() 
    {
        return solutionAnalysis;
    }
    public void setAnswerA(String answerA) 
    {
        this.answerA = answerA;
    }

    public String getAnswerA() 
    {
        return answerA;
    }
    public void setAnswerB(String answerB) 
    {
        this.answerB = answerB;
    }

    public String getAnswerB() 
    {
        return answerB;
    }
    public void setAnswerC(String answerC) 
    {
        this.answerC = answerC;
    }

    public String getAnswerC() 
    {
        return answerC;
    }
    public void setAnswerD(String answerD) 
    {
        this.answerD = answerD;
    }

    public String getAnswerD() 
    {
        return answerD;
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
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pid", getPid())
            .append("itemNo", getItemNo())
            .append("voiceSex", getVoiceSex())
            .append("itemName", getItemName())
            .append("voice", getVoice())
            .append("voiceImg", getVoiceImg())
            .append("solution", getSolution())
            .append("solutionAnalysis", getSolutionAnalysis())
            .append("answerA", getAnswerA())
            .append("answerB", getAnswerB())
            .append("answerC", getAnswerC())
            .append("answerD", getAnswerD())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
