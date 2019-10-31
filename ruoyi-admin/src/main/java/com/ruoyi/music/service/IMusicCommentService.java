package com.ruoyi.music.service;

import com.ruoyi.music.domain.MusicComment;
import java.util.List;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 评论列Service接口
 * 
 * @author echoyu
 * @date 2019-10-31
 */
public interface IMusicCommentService 
{
    /**
     * 查询评论列
     * 
     * @param id 评论列ID
     * @return 评论列
     */
    public MusicComment selectMusicCommentById(String id);

    /**
     * 查询评论列列表
     * 
     * @param musicComment 评论列
     * @return 评论列集合
     */
    public List<MusicComment> selectMusicCommentList(MusicComment musicComment);

    /**
     * 新增评论列
     * 
     * @param musicComment 评论列
     * @return 结果
     */
    public int insertMusicComment(MusicComment musicComment);

    /**
     * 修改评论列
     * 
     * @param musicComment 评论列
     * @return 结果
     */
    public int updateMusicComment(MusicComment musicComment);

    /**
     * 批量删除评论列
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMusicCommentByIds(String ids);

    /**
     * 删除评论列信息
     * 
     * @param id 评论列ID
     * @return 结果
     */
    public int deleteMusicCommentById(String id);

    /**
     * 查询评论列树列表
     * 
     * @return 所有评论列信息
     */
    public List<Ztree> selectMusicCommentTree();
}
