package com.ruoyi.music.service.impl;

import java.util.Date;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.music.mapper.MusicOrderMapper;
import com.ruoyi.music.domain.MusicOrder;
import com.ruoyi.music.service.IMusicOrderService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.IdGenerate;

/**
 * 买会员的订单情况Service业务层处理
 *
 * @author echo
 * @date 2019-10-30
 */
@Service
public class MusicOrderServiceImpl implements IMusicOrderService
{
    @Autowired
    private MusicOrderMapper musicOrderMapper;

    /**
     * 查询买会员的订单情况
     *
     * @param id 买会员的订单情况ID
     * @return 买会员的订单情况
     */
    @Override
    public MusicOrder selectMusicOrderById(String id)
    {
        return musicOrderMapper.selectMusicOrderById(id);
    }

    /**
     * 查询买会员的订单情况列表
     *
     * @param musicOrder 买会员的订单情况
     * @return 买会员的订单情况
     */
    @Override
    public List<MusicOrder> selectMusicOrderList(MusicOrder musicOrder)
    {
        return musicOrderMapper.selectMusicOrderList(musicOrder);
    }

    /**
     * 新增买会员的订单情况
     *
     * @param musicOrder 买会员的订单情况
     * @return 结果
     */
    @Override
    public int insertMusicOrder(MusicOrder musicOrder)
    {
        Date date=new Date();
        musicOrder.setCreateTime(DateUtils.getNowDate());
        musicOrder.setId(IdGenerate.idStr(date));
        musicOrder.setCreateTime(date);
        musicOrder.setUpdateTime(date);
        return musicOrderMapper.insertMusicOrder(musicOrder);
    }

    /**
     * 修改买会员的订单情况
     *
     * @param musicOrder 买会员的订单情况
     * @return 结果
     */
    @Override
    public int updateMusicOrder(MusicOrder musicOrder)
    {
        musicOrder.setUpdateTime(DateUtils.getNowDate());
        return musicOrderMapper.updateMusicOrder(musicOrder);
    }

    /**
     * 删除买会员的订单情况对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMusicOrderByIds(String ids)
    {
        return musicOrderMapper.deleteMusicOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除买会员的订单情况信息
     *
     * @param id 买会员的订单情况ID
     * @return 结果
     */
    @Override
    public int deleteMusicOrderById(String id)
    {
        return musicOrderMapper.deleteMusicOrderById(id);
    }
}
