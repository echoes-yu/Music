package com.ruoyi.web.controller.music;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.music.domain.MusicPay;
import com.ruoyi.music.service.IMusicPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 支付信息模块
 * 
 * @author linpq
 * @date 2019-10-31
 */
@Api("支付信息")
@RestController
@RequestMapping("/music/pay")
public class MusicPayController extends BaseController
{
    private String prefix = "music/pay";

    @Autowired
    private IMusicPayService musicPayService;

    @RequiresPermissions("music:pay:view")
    @GetMapping()
    public String pay()
    {
        return prefix + "/pay";
    }

    /**
     * 查询支付信息列表
     */
    @RequiresPermissions("music:pay:list")
    @PostMapping("/list")
    @ApiOperation("查询支付信息列表")
    public TableDataInfo list(MusicPay musicPay)
    {
        startPage();
        List<MusicPay> list = musicPayService.selectMusicPayList(musicPay);
        return getDataTable(list);
    }

    /**
     * 导出支付信息列表
     */
    @RequiresPermissions("music:pay:export")
    @PostMapping("/export")
    @ApiImplicitParam(name = "musicPay", value = "", required = true, dataType = "MusicPay", paramType = "path")
    public AjaxResult export(MusicPay musicPay)
    {
        List<MusicPay> list = musicPayService.selectMusicPayList(musicPay);
        ExcelUtil<MusicPay> util = new ExcelUtil<MusicPay>(MusicPay.class);
        return util.exportExcel(list, "pay");
    }

    /**
     * 新增支付信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存支付信息
     */
    @RequiresPermissions("music:pay:add")
    @Log(title = "支付信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ApiImplicitParam(name = "musicPay", value = "新增保存支付信息", required = true, dataType = "MusicPay")
    public AjaxResult addSave(MusicPay musicPay)
    {
        return toAjax(musicPayService.insertMusicPay(musicPay));
    }

    /**
     * 修改支付信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
        MusicPay musicPay = musicPayService.selectMusicPayById(id);
        map.put("musicPay", musicPay);
        return prefix + "/edit";
    }

    /**
     * 修改保存支付信息
     */
    @RequiresPermissions("music:pay:edit")
    @Log(title = "支付信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ApiImplicitParam(name = "musicPay", value = "修改保存支付信息", required = true, dataType = "MusicPay")
    public AjaxResult editSave(MusicPay musicPay)
    {
        return toAjax(musicPayService.updateMusicPay(musicPay));
    }

    /**
     * 删除支付信息
     */
    @RequiresPermissions("music:pay:remove")
    @Log(title = "支付信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ApiOperation("删除支付信息")
    @ApiImplicitParam(name = "ids", value = "编号", required = true, dataType = "String", paramType = "path")
    public AjaxResult remove(String ids)
    {
        return toAjax(musicPayService.deleteMusicPayByIds(ids));
    }
}
