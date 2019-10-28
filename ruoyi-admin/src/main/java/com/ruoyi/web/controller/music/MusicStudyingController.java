package com.ruoyi.web.controller.music;

import java.util.List;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.music.domain.MusicStudying;
import com.ruoyi.music.service.IMusicStudyingService;
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
 * 成员学习列Controller
 * 
 * @author linpq
 * @date 2019-10-27
 */
@Controller
@RequestMapping("/system/studying")
public class MusicStudyingController extends BaseController
{
    private String prefix = "system/studying";

    @Autowired
    private IMusicStudyingService musicStudyingService;

    @RequiresPermissions("system:studying:view")
    @GetMapping()
    public String studying()
    {
        return prefix + "/studying";
    }

    /**
     * 查询成员学习列列表
     */
    @RequiresPermissions("system:studying:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MusicStudying musicStudying)
    {
        startPage();
        List<MusicStudying> list = musicStudyingService.selectMusicStudyingList(musicStudying);
        return getDataTable(list);
    }

    /**
     * 导出成员学习列列表
     */
    @RequiresPermissions("system:studying:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MusicStudying musicStudying)
    {
        List<MusicStudying> list = musicStudyingService.selectMusicStudyingList(musicStudying);
        ExcelUtil<MusicStudying> util = new ExcelUtil<MusicStudying>(MusicStudying.class);
        return util.exportExcel(list, "studying");
    }

    /**
     * 新增成员学习列
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存成员学习列
     */
    @RequiresPermissions("system:studying:add")
    @Log(title = "成员学习列", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MusicStudying musicStudying)
    {
        return toAjax(musicStudyingService.insertMusicStudying(musicStudying));
    }

    /**
     * 修改成员学习列
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        MusicStudying musicStudying = musicStudyingService.selectMusicStudyingById(id);
        mmap.put("musicStudying", musicStudying);
        return prefix + "/edit";
    }

    /**
     * 修改保存成员学习列
     */
    @RequiresPermissions("system:studying:edit")
    @Log(title = "成员学习列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MusicStudying musicStudying)
    {
        return toAjax(musicStudyingService.updateMusicStudying(musicStudying));
    }

    /**
     * 删除成员学习列
     */
    @RequiresPermissions("system:studying:remove")
    @Log(title = "成员学习列", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(musicStudyingService.deleteMusicStudyingByIds(ids));
    }
}
