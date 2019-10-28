package com.ruoyi.music.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.IdGenerate;
import com.ruoyi.music.domain.MusicItem;
import com.ruoyi.music.mapper.MusicItemMapper;
import com.ruoyi.music.service.IMusicItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.IdGenerate;
import java.util.List;

/**
 * 音乐试题Service业务层处理
 *
 * @author linpq
 * @date 2019-10-27
 */
@Service
public class MusicItemServiceImpl implements IMusicItemService
{
    @Autowired
    private MusicItemMapper musicItemMapper;

    /**
     * 查询音乐试题
     *
     * @param id 音乐试题ID
     * @return 音乐试题
     */
    @Override
    public MusicItem selectMusicItemById(String id)
    {
        return musicItemMapper.selectMusicItemById(id);
    }

    /**
     * 查询音乐试题列表
     *
     * @param musicItem 音乐试题
     * @return 音乐试题
     */
    @Override
    public List<MusicItem> selectMusicItemList(MusicItem musicItem)
    {
        return musicItemMapper.selectMusicItemList(musicItem);
    }

    /**
     * 新增音乐试题
     *
     * @param musicItem 音乐试题
     * @return 结果
     */
    @Override
    public int insertMusicItem(MusicItem musicItem)
    {
        musicItem.setCreateTime(DateUtils.getNowDate());
        musicItem.setId(IdGenerate.uuid());
        return musicItemMapper.insertMusicItem(musicItem);
    }

    /**
     * 修改音乐试题
     *
     * @param musicItem 音乐试题
     * @return 结果
     */
    @Override
    public int updateMusicItem(MusicItem musicItem)
    {
        musicItem.setUpdateTime(DateUtils.getNowDate());
        return musicItemMapper.updateMusicItem(musicItem);
    }

    /**
     * 删除音乐试题对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMusicItemByIds(String ids)
    {
        return musicItemMapper.deleteMusicItemByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除音乐试题信息
     *
     * @param id 音乐试题ID
     * @return 结果
     */
    @Override
    public int deleteMusicItemById(String id)
    {
        return musicItemMapper.deleteMusicItemById(id);
    }
}
