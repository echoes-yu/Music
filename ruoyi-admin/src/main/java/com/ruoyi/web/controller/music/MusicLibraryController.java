package com.ruoyi.web.controller.music;

import java.util.List;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.music.domain.MusicLibrary;
import com.ruoyi.music.service.IMusicLibraryService;
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
 * 音乐题库Controller
 * 
 * @author linpq
 * @date 2019-10-27
 */
@Controller
@RequestMapping("/system/library")
public class MusicLibraryController extends BaseController
{
    private String prefix = "system/library";

    @Autowired
    private IMusicLibraryService musicLibraryService;

    @RequiresPermissions("system:library:view")
    @GetMapping()
    public String library()
    {
        return prefix + "/library";
    }

    /**
     * 查询音乐题库列表
     */
    @RequiresPermissions("system:library:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MusicLibrary musicLibrary)
    {
        startPage();
        List<MusicLibrary> list = musicLibraryService.selectMusicLibraryList(musicLibrary);
        return getDataTable(list);
    }

    /**
     * 导出音乐题库列表
     */
    @RequiresPermissions("system:library:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MusicLibrary musicLibrary)
    {
        List<MusicLibrary> list = musicLibraryService.selectMusicLibraryList(musicLibrary);
        ExcelUtil<MusicLibrary> util = new ExcelUtil<MusicLibrary>(MusicLibrary.class);
        return util.exportExcel(list, "library");
    }

    /**
     * 新增音乐题库
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存音乐题库
     */
    @RequiresPermissions("system:library:add")
    @Log(title = "音乐题库", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MusicLibrary musicLibrary)
    {
        return toAjax(musicLibraryService.insertMusicLibrary(musicLibrary));
    }

    /**
     * 修改音乐题库
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        MusicLibrary musicLibrary = musicLibraryService.selectMusicLibraryById(id);
        mmap.put("musicLibrary", musicLibrary);
        return prefix + "/edit";
    }

    /**
     * 修改保存音乐题库
     */
    @RequiresPermissions("system:library:edit")
    @Log(title = "音乐题库", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MusicLibrary musicLibrary)
    {
        return toAjax(musicLibraryService.updateMusicLibrary(musicLibrary));
    }

    /**
     * 删除音乐题库
     */
    @RequiresPermissions("system:library:remove")
    @Log(title = "音乐题库", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(musicLibraryService.deleteMusicLibraryByIds(ids));
    }
}
