package com.ruoyi.music.mapper;

import com.ruoyi.music.domain.MusicMember;
import java.util.List;

/**
 * 音乐会员Mapper接口
 * 
 * @author echoyu
 * @date 2019-10-31
 */
public interface MusicMemberMapper 
{
    /**
     * 查询音乐会员
     * 
     * @param id 音乐会员ID
     * @return 音乐会员
     */
    public MusicMember selectMusicMemberById(String id);

    /**
     * 查询音乐会员列表
     * 
     * @param musicMember 音乐会员
     * @return 音乐会员集合
     */
    public List<MusicMember> selectMusicMemberList(MusicMember musicMember);

    /**
     * 新增音乐会员
     * 
     * @param musicMember 音乐会员
     * @return 结果
     */
    public int insertMusicMember(MusicMember musicMember);

    /**
     * 修改音乐会员
     * 
     * @param musicMember 音乐会员
     * @return 结果
     */
    public int updateMusicMember(MusicMember musicMember);

    /**
     * 删除音乐会员
     * 
     * @param id 音乐会员ID
     * @return 结果
     */
    public int deleteMusicMemberById(String id);

    /**
     * 批量删除音乐会员
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMusicMemberByIds(String[] ids);
}
