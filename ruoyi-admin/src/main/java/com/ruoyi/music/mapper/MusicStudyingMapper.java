package com.ruoyi.music.mapper;

import com.ruoyi.music.domain.MusicStudying;
import java.util.List;

/**
 * 成员学习记录Mapper接口
 * 
 * @author echoyu
 * @date 2019-10-31
 */
public interface MusicStudyingMapper 
{
    /**
     * 查询成员学习记录
     * 
     * @param id 成员学习记录ID
     * @return 成员学习记录
     */
    public MusicStudying selectMusicStudyingById(String id);

    /**
     * 查询成员学习记录列表
     * 
     * @param musicStudying 成员学习记录
     * @return 成员学习记录集合
     */
    public List<MusicStudying> selectMusicStudyingList(MusicStudying musicStudying);

    /**
     * 新增成员学习记录
     * 
     * @param musicStudying 成员学习记录
     * @return 结果
     */
    public int insertMusicStudying(MusicStudying musicStudying);

    /**
     * 修改成员学习记录
     * 
     * @param musicStudying 成员学习记录
     * @return 结果
     */
    public int updateMusicStudying(MusicStudying musicStudying);

    /**
     * 删除成员学习记录
     * 
     * @param id 成员学习记录ID
     * @return 结果
     */
    public int deleteMusicStudyingById(String id);

    /**
     * 批量删除成员学习记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMusicStudyingByIds(String[] ids);
}
