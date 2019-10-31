package com.ruoyi.music.service.impl;

import java.util.Date;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.music.mapper.MusicMemberMapper;
import com.ruoyi.music.domain.MusicMember;
import com.ruoyi.music.service.IMusicMemberService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.IdGenerate;

/**
 * 音乐会员Service业务层处理
 *
 * @author echoyu
 * @date 2019-10-30
 */
@Service
public class MusicMemberServiceImpl implements IMusicMemberService
{
    @Autowired
    private MusicMemberMapper musicMemberMapper;

    /**
     * 查询音乐会员
     *
     * @param id 音乐会员ID
     * @return 音乐会员
     */
    @Override
    public MusicMember selectMusicMemberById(String id)
    {
        return musicMemberMapper.selectMusicMemberById(id);
    }

    /**
     * 查询音乐会员列表
     *
     * @param musicMember 音乐会员
     * @return 音乐会员
     */
    @Override
    public List<MusicMember> selectMusicMemberList(MusicMember musicMember)
    {
        return musicMemberMapper.selectMusicMemberList(musicMember);
    }

    /**
     * 新增音乐会员
     *
     * @param musicMember 音乐会员
     * @return 结果
     */
    @Override
    public int insertMusicMember(MusicMember musicMember)
    {
        Date date=new Date();
        musicMember.setCreateTime(DateUtils.getNowDate());
        musicMember.setId(IdGenerate.idStr(date));
        musicMember.setCreateTime(date);
        musicMember.setUpdateTime(date);
        musicMember.setRoleNo("1");//给个默认值
        if (StringUtils.isEmpty(musicMember.getIsMember()))
            musicMember.setIsMember("N");
        return musicMemberMapper.insertMusicMember(musicMember);
    }

    /**
     * 修改音乐会员
     *
     * @param musicMember 音乐会员
     * @return 结果
     */
    @Override
    public int updateMusicMember(MusicMember musicMember)
    {
        musicMember.setUpdateTime(DateUtils.getNowDate());
        return musicMemberMapper.updateMusicMember(musicMember);
    }

    /**
     * 删除音乐会员对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMusicMemberByIds(String ids)
    {
        return musicMemberMapper.deleteMusicMemberByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除音乐会员信息
     *
     * @param id 音乐会员ID
     * @return 结果
     */
    @Override
    public int deleteMusicMemberById(String id)
    {
        return musicMemberMapper.deleteMusicMemberById(id);
    }
}
