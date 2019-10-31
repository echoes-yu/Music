package com.ruoyi.music.mapper;

import com.ruoyi.music.domain.MusicConsultation;
import java.util.List;

/**
 * 学考咨询Mapper接口
 * 
 * @author echoyu
 * @date 2019-10-31
 */
public interface MusicConsultationMapper 
{
    /**
     * 查询学考咨询
     * 
     * @param id 学考咨询ID
     * @return 学考咨询
     */
    public MusicConsultation selectMusicConsultationById(String id);

    /**
     * 查询学考咨询列表
     * 
     * @param musicConsultation 学考咨询
     * @return 学考咨询集合
     */
    public List<MusicConsultation> selectMusicConsultationList(MusicConsultation musicConsultation);

    /**
     * 新增学考咨询
     * 
     * @param musicConsultation 学考咨询
     * @return 结果
     */
    public int insertMusicConsultation(MusicConsultation musicConsultation);

    /**
     * 修改学考咨询
     * 
     * @param musicConsultation 学考咨询
     * @return 结果
     */
    public int updateMusicConsultation(MusicConsultation musicConsultation);

    /**
     * 删除学考咨询
     * 
     * @param id 学考咨询ID
     * @return 结果
     */
    public int deleteMusicConsultationById(String id);

    /**
     * 批量删除学考咨询
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMusicConsultationByIds(String[] ids);
}
