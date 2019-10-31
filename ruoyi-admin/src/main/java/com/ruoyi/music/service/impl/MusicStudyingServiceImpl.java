package com.ruoyi.music.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.IdGenerate;
import com.ruoyi.music.domain.MusicStudying;
import com.ruoyi.music.mapper.MusicStudyingMapper;
import com.ruoyi.music.service.IMusicStudyingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 * 成员学习列Service业务层处理
 *
 * @author linpq
 * @date 2019-10-27
 */
@Service
public class MusicStudyingServiceImpl implements IMusicStudyingService
{
    @Autowired
    private MusicStudyingMapper musicStudyingMapper;

    /**
     * 查询成员学习列
     *
     * @param id 成员学习列ID
     * @return 成员学习列
     */
    @Override
    public MusicStudying selectMusicStudyingById(String id)
    {
        return musicStudyingMapper.selectMusicStudyingById(id);
    }

    /**
     * 查询成员学习列列表
     *
     * @param musicStudying 成员学习列
     * @return 成员学习列
     */
    @Override
    public List<MusicStudying> selectMusicStudyingList(MusicStudying musicStudying)
    {
        return musicStudyingMapper.selectMusicStudyingList(musicStudying);
    }

    /**
     * 新增成员学习列
     *
     * @param musicStudying 成员学习列
     * @return 结果
     */
    @Override
    public int insertMusicStudying(MusicStudying musicStudying)
    {
        Date date=new Date();
        musicStudying.setCreateTime(DateUtils.getNowDate());
        musicStudying.setId(IdGenerate.idStr(date));
        musicStudying.setCreateTime(date);
        musicStudying.setUpdateTime(date);
        return musicStudyingMapper.insertMusicStudying(musicStudying);
    }

    /**
     * 修改成员学习列
     *
     * @param musicStudying 成员学习列
     * @return 结果
     */
    @Override
    public int updateMusicStudying(MusicStudying musicStudying)
    {
        musicStudying.setUpdateTime(DateUtils.getNowDate());
        return musicStudyingMapper.updateMusicStudying(musicStudying);
    }

    /**
     * 删除成员学习列对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMusicStudyingByIds(String ids)
    {
        return musicStudyingMapper.deleteMusicStudyingByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除成员学习列信息
     *
     * @param id 成员学习列ID
     * @return 结果
     */
    @Override
    public int deleteMusicStudyingById(String id)
    {
        return musicStudyingMapper.deleteMusicStudyingById(id);
    }
}
