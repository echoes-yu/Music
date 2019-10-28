package com.ruoyi.web.controller.music;

import java.util.List;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.music.domain.MusicPay;
import com.ruoyi.music.service.IMusicPayService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 支付信息Controller
 * 
 * @author linpq
 * @date 2019-10-27
 */
@Controller
@RequestMapping("/system/pay")
public class MusicPayController extends BaseController
{
    private String prefix = "system/pay";

    @Autowired
    private IMusicPayService musicPayService;

    @RequiresPermissions("system:pay:view")
    @GetMapping()
    public String pay()
    {
        return prefix + "/pay";
    }

    /**
     * 查询支付信息列表
     */
    @RequiresPermissions("system:pay:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MusicPay musicPay)
    {
        startPage();
        List<MusicPay> list = musicPayService.selectMusicPayList(musicPay);
        return getDataTable(list);
    }

    /**
     * 导出支付信息列表
     */
    @RequiresPermissions("system:pay:export")
    @PostMapping("/export")
    @ResponseBody
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
    @RequiresPermissions("system:pay:add")
    @Log(title = "支付信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MusicPay musicPay)
    {
        return toAjax(musicPayService.insertMusicPay(musicPay));
    }

    /**
     * 修改支付信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        MusicPay musicPay = musicPayService.selectMusicPayById(id);
        mmap.put("musicPay", musicPay);
        return prefix + "/edit";
    }

    /**
     * 修改保存支付信息
     */
    @RequiresPermissions("system:pay:edit")
    @Log(title = "支付信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MusicPay musicPay)
    {
        return toAjax(musicPayService.updateMusicPay(musicPay));
    }

    /**
     * 删除支付信息
     */
    @RequiresPermissions("system:pay:remove")
    @Log(title = "支付信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(musicPayService.deleteMusicPayByIds(ids));
    }
}
