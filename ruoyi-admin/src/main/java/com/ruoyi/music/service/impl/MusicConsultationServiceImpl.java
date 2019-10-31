package com.ruoyi.music.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.IdGenerate;
import com.ruoyi.music.domain.MusicConsultation;
import com.ruoyi.music.mapper.MusicConsultationMapper;
import com.ruoyi.music.service.IMusicConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 学考咨询Service业务层处理
 *
 * @author echoyu
 * @date 2019-10-27
 */
@Service
public class MusicConsultationServiceImpl implements IMusicConsultationService {
    @Autowired
    private MusicConsultationMapper musicConsultationMapper;

    /**
     * 查询学考咨询
     *
     * @param id 学考咨询ID
     * @return 学考咨询
     */
    @Override
    public MusicConsultation selectMusicConsultationById(String id) {
        return musicConsultationMapper.selectMusicConsultationById(id);
    }

    /**
     * 查询学考咨询列表
     *
     * @param musicConsultation 学考咨询
     * @return 学考咨询
     */
    @Override
    public List<MusicConsultation> selectMusicConsultationList(MusicConsultation musicConsultation) {
        return musicConsultationMapper.selectMusicConsultationList(musicConsultation);
    }

    /**
     * 新增学考咨询
     *
     * @param musicConsultation 学考咨询
     * @return 结果
     */
    @Override
    public int insertMusicConsultation(MusicConsultation musicConsultation) {
        Date date=new Date();
        musicConsultation.setCreateTime(DateUtils.getNowDate());
        musicConsultation.setId(IdGenerate.idStr(date));
        return musicConsultationMapper.insertMusicConsultation(musicConsultation);
    }

    /**
     * 修改学考咨询
     *
     * @param musicConsultation 学考咨询
     * @return 结果
     */
    @Override
    public int updateMusicConsultation(MusicConsultation musicConsultation) {
        musicConsultation.setUpdateTime(DateUtils.getNowDate());
        return musicConsultationMapper.updateMusicConsultation(musicConsultation);
    }

    /**
     * 删除学考咨询对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMusicConsultationByIds(String ids) {
        return musicConsultationMapper.deleteMusicConsultationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学考咨询信息
     *
     * @param id 学考咨询ID
     * @return 结果
     */
    @Override
    public int deleteMusicConsultationById(String id) {
        return musicConsultationMapper.deleteMusicConsultationById(id);
    }
}
