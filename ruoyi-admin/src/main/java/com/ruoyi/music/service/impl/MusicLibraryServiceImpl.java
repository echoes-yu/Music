package com.ruoyi.music.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.IdGenerate;
import com.ruoyi.music.domain.MusicLibrary;
import com.ruoyi.music.mapper.MusicLibraryMapper;
import com.ruoyi.music.service.IMusicLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 音乐题库Service业务层处理
 *
 * @author echoyu
 * @date 2019-10-27
 */
@Service
public class MusicLibraryServiceImpl implements IMusicLibraryService
{
    @Autowired
    private MusicLibraryMapper musicLibraryMapper;

    /**
     * 查询音乐题库
     *
     * @param id 音乐题库ID
     * @return 音乐题库
     */
    @Override
    public MusicLibrary selectMusicLibraryById(String id)
    {
        return musicLibraryMapper.selectMusicLibraryById(id);
    }

    /**
     * 查询音乐题库列表
     *
     * @param musicLibrary 音乐题库
     * @return 音乐题库
     */
    @Override
    public List<MusicLibrary> selectMusicLibraryList(MusicLibrary musicLibrary)
    {
        return musicLibraryMapper.selectMusicLibraryList(musicLibrary);
    }

    /**
     * 新增音乐题库
     *
     * @param musicLibrary 音乐题库
     * @return 结果
     */
    @Override
    public int insertMusicLibrary(MusicLibrary musicLibrary)
    {

        Date date=new Date();
        musicLibrary.setCreateTime(DateUtils.getNowDate());
        musicLibrary.setId(IdGenerate.idStr(date));
        musicLibrary.setCreateTime(date);
        musicLibrary.setUpdateTime(date);
        return musicLibraryMapper.insertMusicLibrary(musicLibrary);
    }

    /**
     * 修改音乐题库
     *
     * @param musicLibrary 音乐题库
     * @return 结果
     */
    @Override
    public int updateMusicLibrary(MusicLibrary musicLibrary)
    {
        musicLibrary.setUpdateTime(DateUtils.getNowDate());
        return musicLibraryMapper.updateMusicLibrary(musicLibrary);
    }

    /**
     * 删除音乐题库对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMusicLibraryByIds(String ids)
    {
        return musicLibraryMapper.deleteMusicLibraryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除音乐题库信息
     *
     * @param id 音乐题库ID
     * @return 结果
     */
    @Override
    public int deleteMusicLibraryById(String id)
    {
        return musicLibraryMapper.deleteMusicLibraryById(id);
    }
}
