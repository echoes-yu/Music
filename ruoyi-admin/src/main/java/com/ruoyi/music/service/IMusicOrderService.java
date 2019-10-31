package com.ruoyi.music.service;

import com.ruoyi.music.domain.MusicOrder;
import java.util.List;

/**
 * 买会员的订单情况Service接口
 * 
 * @author echo
 * @date 2019-10-31
 */
public interface IMusicOrderService 
{
    /**
     * 查询买会员的订单情况
     * 
     * @param id 买会员的订单情况ID
     * @return 买会员的订单情况
     */
    public MusicOrder selectMusicOrderById(String id);

    /**
     * 查询买会员的订单情况列表
     * 
     * @param musicOrder 买会员的订单情况
     * @return 买会员的订单情况集合
     */
    public List<MusicOrder> selectMusicOrderList(MusicOrder musicOrder);

    /**
     * 新增买会员的订单情况
     * 
     * @param musicOrder 买会员的订单情况
     * @return 结果
     */
    public int insertMusicOrder(MusicOrder musicOrder);

    /**
     * 修改买会员的订单情况
     * 
     * @param musicOrder 买会员的订单情况
     * @return 结果
     */
    public int updateMusicOrder(MusicOrder musicOrder);

    /**
     * 批量删除买会员的订单情况
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMusicOrderByIds(String ids);

    /**
     * 删除买会员的订单情况信息
     * 
     * @param id 买会员的订单情况ID
     * @return 结果
     */
    public int deleteMusicOrderById(String id);
}
