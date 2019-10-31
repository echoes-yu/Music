package com.ruoyi.music.mapper;

import com.ruoyi.music.domain.MusicPay;
import java.util.List;

/**
 * 支付信息Mapper接口
 * 
 * @author echoyu
 * @date 2019-10-31
 */
public interface MusicPayMapper 
{
    /**
     * 查询支付信息
     * 
     * @param id 支付信息ID
     * @return 支付信息
     */
    public MusicPay selectMusicPayById(String id);

    /**
     * 查询支付信息列表
     * 
     * @param musicPay 支付信息
     * @return 支付信息集合
     */
    public List<MusicPay> selectMusicPayList(MusicPay musicPay);

    /**
     * 新增支付信息
     * 
     * @param musicPay 支付信息
     * @return 结果
     */
    public int insertMusicPay(MusicPay musicPay);

    /**
     * 修改支付信息
     * 
     * @param musicPay 支付信息
     * @return 结果
     */
    public int updateMusicPay(MusicPay musicPay);

    /**
     * 删除支付信息
     * 
     * @param id 支付信息ID
     * @return 结果
     */
    public int deleteMusicPayById(String id);

    /**
     * 批量删除支付信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMusicPayByIds(String[] ids);
}
