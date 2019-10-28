package com.ruoyi.music.mapper;

import com.ruoyi.music.domain.MusicComment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评论列Mapper接口
 * 
 * @author linpq
 * @date 2019-10-27
 */
@Repository
public interface MusicCommentMapper 
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
     * 删除评论列
     * 
     * @param id 评论列ID
     * @return 结果
     */
    public int deleteMusicCommentById(String id);

    /**
     * 批量删除评论列
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMusicCommentByIds(String[] ids);
}
