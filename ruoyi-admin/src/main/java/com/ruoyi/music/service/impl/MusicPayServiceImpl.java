package com.ruoyi.music.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.IdGenerate;
import com.ruoyi.music.domain.MusicPay;
import com.ruoyi.music.mapper.MusicPayMapper;
import com.ruoyi.music.service.IMusicPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 * 支付信息Service业务层处理
 *
 * @author echoyu
 * @date 2019-10-27
 */
@Service
public class MusicPayServiceImpl implements IMusicPayService
{
    @Autowired
    private MusicPayMapper musicPayMapper;

    /**
     * 查询支付信息
     *
     * @param id 支付信息ID
     * @return 支付信息
     */
    @Override
    public MusicPay selectMusicPayById(String id)
    {
        return musicPayMapper.selectMusicPayById(id);
    }

    /**
     * 查询支付信息列表
     *
     * @param musicPay 支付信息
     * @return 支付信息
     */
    @Override
    public List<MusicPay> selectMusicPayList(MusicPay musicPay)
    {
        return musicPayMapper.selectMusicPayList(musicPay);
    }

    /**
     * 新增支付信息
     *
     * @param musicPay 支付信息
     * @return 结果
     */
    @Override
    public int insertMusicPay(MusicPay musicPay)
    {
        Date date=new Date();
        musicPay.setCreateTime(DateUtils.getNowDate());
        musicPay.setId(IdGenerate.idStr(date));
        musicPay.setCreateTime(date);
        musicPay.setUpdateTime(date);
        return musicPayMapper.insertMusicPay(musicPay);
    }

    /**
     * 修改支付信息
     *
     * @param musicPay 支付信息
     * @return 结果
     */
    @Override
    public int updateMusicPay(MusicPay musicPay)
    {
        musicPay.setUpdateTime(DateUtils.getNowDate());
        return musicPayMapper.updateMusicPay(musicPay);
    }

    /**
     * 删除支付信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMusicPayByIds(String ids)
    {
        return musicPayMapper.deleteMusicPayByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除支付信息信息
     *
     * @param id 支付信息ID
     * @return 结果
     */
    @Override
    public int deleteMusicPayById(String id)
    {
        return musicPayMapper.deleteMusicPayById(id);
    }
}
