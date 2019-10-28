package com.ruoyi.web.controller.music;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.music.domain.MusicConsultation;
import com.ruoyi.music.service.IMusicConsultationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 学考咨询Controller
 * 
 * @author linpq
 * @date 2019-10-27
 */
@Controller
@RequestMapping("/system/consultation")
public class MusicConsultationController extends BaseController
{
    private String prefix = "system/consultation";

    @Autowired
    private IMusicConsultationService musicConsultationService;

    @RequiresPermissions("system:consultation:view")
    @GetMapping()
    public String consultation()
    {
        return prefix + "/consultation";
    }

    /**
     * 查询学考咨询列表
     */
    @RequiresPermissions("system:consultation:list")
    @PostMapping("/list")
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
    @RequiresPermissions("system:consultation:export")
    @PostMapping("/export")
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
    @RequiresPermissions("system:consultation:add")
    @Log(title = "学考咨询", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MusicConsultation musicConsultation)
    {
        return toAjax(musicConsultationService.insertMusicConsultation(musicConsultation));
    }

    /**
     * 修改学考咨询
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        MusicConsultation musicConsultation = musicConsultationService.selectMusicConsultationById(id);
        mmap.put("musicConsultation", musicConsultation);
        return prefix + "/edit";
    }

    /**
     * 修改保存学考咨询
     */
    @RequiresPermissions("system:consultation:edit")
    @Log(title = "学考咨询", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MusicConsultation musicConsultation)
    {
        return toAjax(musicConsultationService.updateMusicConsultation(musicConsultation));
    }

    /**
     * 删除学考咨询
     */
    @RequiresPermissions("system:consultation:remove")
    @Log(title = "学考咨询", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(musicConsultationService.deleteMusicConsultationByIds(ids));
    }
}
