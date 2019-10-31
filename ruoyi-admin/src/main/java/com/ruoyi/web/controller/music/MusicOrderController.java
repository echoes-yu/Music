package com.ruoyi.web.controller.music;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.music.domain.MusicOrder;
import com.ruoyi.music.service.IMusicOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 买会员的订单情况模块
 * 
 * @author echo
 * @date 2019-10-31
 */
@Api("买会员的订单情况")
@RestController
@RequestMapping("/music/order")
public class MusicOrderController extends BaseController
{
    private String prefix = "music/order";

    @Autowired
    private IMusicOrderService musicOrderService;

    @RequiresPermissions("music:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询买会员的订单情况列表
     */
    @RequiresPermissions("music:order:list")
    @PostMapping("/list")
    @ApiOperation("查询买会员的订单情况列表")
    public TableDataInfo list(MusicOrder musicOrder)
    {
        startPage();
        List<MusicOrder> list = musicOrderService.selectMusicOrderList(musicOrder);
        return getDataTable(list);
    }

    /**
     * 导出买会员的订单情况列表
     */
    @RequiresPermissions("music:order:export")
    @PostMapping("/export")
    @ApiImplicitParam(name = "musicOrder", value = "", required = true, dataType = "MusicOrder", paramType = "path")
    public AjaxResult export(MusicOrder musicOrder)
    {
        List<MusicOrder> list = musicOrderService.selectMusicOrderList(musicOrder);
        ExcelUtil<MusicOrder> util = new ExcelUtil<MusicOrder>(MusicOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 新增买会员的订单情况
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存买会员的订单情况
     */
    @RequiresPermissions("music:order:add")
    @Log(title = "买会员的订单情况", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ApiImplicitParam(name = "musicOrder", value = "新增保存买会员的订单情况", required = true, dataType = "MusicOrder")
    public AjaxResult addSave(MusicOrder musicOrder)
    {
        return toAjax(musicOrderService.insertMusicOrder(musicOrder));
    }

    /**
     * 修改买会员的订单情况
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
        MusicOrder musicOrder = musicOrderService.selectMusicOrderById(id);
        map.put("musicOrder", musicOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存买会员的订单情况
     */
    @RequiresPermissions("music:order:edit")
    @Log(title = "买会员的订单情况", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ApiImplicitParam(name = "musicOrder", value = "修改保存买会员的订单情况", required = true, dataType = "MusicOrder")
    public AjaxResult editSave(MusicOrder musicOrder)
    {
        return toAjax(musicOrderService.updateMusicOrder(musicOrder));
    }

    /**
     * 删除买会员的订单情况
     */
    @RequiresPermissions("music:order:remove")
    @Log(title = "买会员的订单情况", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ApiOperation("删除买会员的订单情况")
    @ApiImplicitParam(name = "ids", value = "编号", required = true, dataType = "String", paramType = "path")
    public AjaxResult remove(String ids)
    {
        return toAjax(musicOrderService.deleteMusicOrderByIds(ids));
    }
}
