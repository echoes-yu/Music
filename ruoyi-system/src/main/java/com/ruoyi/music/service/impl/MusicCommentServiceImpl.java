package com.ruoyi.music.service.impl;

import com.ruoyi.music.domain.MusicComment;
import com.ruoyi.music.mapper.MusicCommentMapper;
import com.ruoyi.music.service.IMusicCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.IdGenerate;
/**
 * 评论列Service业务层处理
 *
 * @author linpq
 * @date 2019-10-27
 */
@Service
public class MusicCommentServiceImpl implements IMusicCommentService
{
    @Autowired
    private MusicCommentMapper musicCommentMapper;

    /**
     * 查询评论列
     *
     * @param id 评论列ID
     * @return 评论列
     */
    @Override
    public MusicComment selectMusicCommentById(String id)
    {
        return musicCommentMapper.selectMusicCommentById(id);
    }

    /**
     * 查询评论列列表
     *
     * @param musicComment 评论列
     * @return 评论列
     */
    @Override
    public List<MusicComment> selectMusicCommentList(MusicComment musicComment)
    {
        return musicCommentMapper.selectMusicCommentList(musicComment);
    }

    /**
     * 新增评论列
     *
     * @param musicComment 评论列
     * @return 结果
     */
    @Override
    public int insertMusicComment(MusicComment musicComment)
    {
        musicComment.setCreateTime(DateUtils.getNowDate());
        musicComment.setId(IdGenerate.uuid());
        return musicCommentMapper.insertMusicComment(musicComment);
    }

    /**
     * 修改评论列
     *
     * @param musicComment 评论列
     * @return 结果
     */
    @Override
    public int updateMusicComment(MusicComment musicComment)
    {
        musicComment.setUpdateTime(DateUtils.getNowDate());
        return musicCommentMapper.updateMusicComment(musicComment);
    }

    /**
     * 删除评论列对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMusicCommentByIds(String ids)
    {
        return musicCommentMapper.deleteMusicCommentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除评论列信息
     *
     * @param id 评论列ID
     * @return 结果
     */
    @Override
    public int deleteMusicCommentById(String id)
    {
        return musicCommentMapper.deleteMusicCommentById(id);
    }
}
