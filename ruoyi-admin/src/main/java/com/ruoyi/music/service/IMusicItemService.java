package com.ruoyi.music.service;

import com.ruoyi.music.domain.MusicItem;
import java.util.List;

/**
 * 音乐试题Service接口
 * 
 * @author echoyu
 * @date 2019-10-31
 */
public interface IMusicItemService 
{
    /**
     * 查询音乐试题
     * 
     * @param id 音乐试题ID
     * @return 音乐试题
     */
    public MusicItem selectMusicItemById(String id);

    /**
     * 查询音乐试题列表
     * 
     * @param musicItem 音乐试题
     * @return 音乐试题集合
     */
    public List<MusicItem> selectMusicItemList(MusicItem musicItem);

    /**
     * 新增音乐试题
     * 
     * @param musicItem 音乐试题
     * @return 结果
     */
    public int insertMusicItem(MusicItem musicItem);

    /**
     * 修改音乐试题
     * 
     * @param musicItem 音乐试题
     * @return 结果
     */
    public int updateMusicItem(MusicItem musicItem);

    /**
     * 批量删除音乐试题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMusicItemByIds(String ids);

    /**
     * 删除音乐试题信息
     * 
     * @param id 音乐试题ID
     * @return 结果
     */
    public int deleteMusicItemById(String id);
}
