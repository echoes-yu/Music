package com.ruoyi.music.service;


import com.ruoyi.music.domain.MusicLibrary;

import java.util.List;

/**
 * 音乐题库Service接口
 * 
 * @author linpq
 * @date 2019-10-27
 */
public interface IMusicLibraryService 
{
    /**
     * 查询音乐题库
     * 
     * @param id 音乐题库ID
     * @return 音乐题库
     */
    public MusicLibrary selectMusicLibraryById(String id);

    /**
     * 查询音乐题库列表
     * 
     * @param musicLibrary 音乐题库
     * @return 音乐题库集合
     */
    public List<MusicLibrary> selectMusicLibraryList(MusicLibrary musicLibrary);

    /**
     * 新增音乐题库
     * 
     * @param musicLibrary 音乐题库
     * @return 结果
     */
    public int insertMusicLibrary(MusicLibrary musicLibrary);

    /**
     * 修改音乐题库
     * 
     * @param musicLibrary 音乐题库
     * @return 结果
     */
    public int updateMusicLibrary(MusicLibrary musicLibrary);

    /**
     * 批量删除音乐题库
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMusicLibraryByIds(String ids);

    /**
     * 删除音乐题库信息
     * 
     * @param id 音乐题库ID
     * @return 结果
     */
    public int deleteMusicLibraryById(String id);
}
