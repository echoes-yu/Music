package com.ruoyi.music.service;

import com.ruoyi.music.domain.MusicStudying;

import java.util.List;

/**
 * 成员学习列Service接口
 * 
 * @author linpq
 * @date 2019-10-27
 */
public interface IMusicStudyingService 
{
    /**
     * 查询成员学习列
     * 
     * @param id 成员学习列ID
     * @return 成员学习列
     */
    public MusicStudying selectMusicStudyingById(String id);

    /**
     * 查询成员学习列列表
     * 
     * @param musicStudying 成员学习列
     * @return 成员学习列集合
     */
    public List<MusicStudying> selectMusicStudyingList(MusicStudying musicStudying);

    /**
     * 新增成员学习列
     * 
     * @param musicStudying 成员学习列
     * @return 结果
     */
    public int insertMusicStudying(MusicStudying musicStudying);

    /**
     * 修改成员学习列
     * 
     * @param musicStudying 成员学习列
     * @return 结果
     */
    public int updateMusicStudying(MusicStudying musicStudying);

    /**
     * 批量删除成员学习列
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMusicStudyingByIds(String ids);

    /**
     * 删除成员学习列信息
     * 
     * @param id 成员学习列ID
     * @return 结果
     */
    public int deleteMusicStudyingById(String id);
}
