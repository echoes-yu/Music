package com.ruoyi.web.controller.music;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.music.domain.MusicConsultation;
import com.ruoyi.music.service.IMusicConsultationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 学考咨询模块
 * 
 * @author echoyu
 * @date 2019-10-31
 */
@Api("学考咨询")
@Controller
@RequestMapping("/music/consultation")
public class MusicConsultationController extends BaseController
{
    private String prefix = "music/consultation";

    @Autowired
    private IMusicConsultationService musicConsultationService;

    @RequiresPermissions("music:consultation:view")
    @GetMapping()
    public String consultation()
    {
        return prefix + "/consultation";
    }

    /**
     * 查询学考咨询列表
     */
    @RequiresPermissions("music:consultation:list")
    @PostMapping("/list")
    @ApiOperation("查询学考咨询列表")
    @ResponseBody
    public TableDataInfo list(MusicConsultation musicConsultation)
    {
        startPage();
        List<MusicConsultation> list = musicConsultationService.selectMusicConsultationList(musicConsultation);
        return getDataTable(list);
    }

    /**
     * 导出学考咨询列表
     */
    @RequiresPermissions("music:consultation:export")
    @PostMapping("/export")
    @ApiOperation("导出学考咨询")
    @ResponseBody
    public AjaxResult export(MusicConsultation musicConsultation)
    {
        List<MusicConsultation> list = musicConsultationService.selectMusicConsultationList(musicConsultation);
        ExcelUtil<MusicConsultation> util = new ExcelUtil<MusicConsultation>(MusicConsultation.class);
        return util.exportExcel(list, "consultation");
    }

    /**
     * 新增学考咨询
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学考咨询
     */
    @RequiresPermissions("music:consultation:add")
    @Log(title = "学考咨询", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ApiOperation("新增保存学考咨询")
    @ResponseBody
    public AjaxResult addSave(MusicConsultation musicConsultation)
    {
        return toAjax(musicConsultationService.insertMusicConsultation(musicConsultation));
    }

    /**
     * 修改学考咨询
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
        MusicConsultation musicConsultation = musicConsultationService.selectMusicConsultationById(id);
        map.put("musicConsultation", musicConsultation);
        return prefix + "/edit";
    }

    /**
     * 修改保存学考咨询
     */
    @RequiresPermissions("music:consultation:edit")
    @Log(title = "学考咨询", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ApiImplicitParam(name = "musicConsultation", value = "修改保存学考咨询", required = true,dataType = "MusicConsultation")
    public AjaxResult editSave(MusicConsultation musicConsultation)
    {
        return toAjax(musicConsultationService.updateMusicConsultation(musicConsultation));
    }

    /**
     * 删除学考咨询
     */
    @RequiresPermissions("music:consultation:remove")
    @Log(title = "学考咨询", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ApiOperation("删除学考咨询")
    public AjaxResult remove(String ids)
    {
        return toAjax(musicConsultationService.deleteMusicConsultationByIds(ids));
    }
}
