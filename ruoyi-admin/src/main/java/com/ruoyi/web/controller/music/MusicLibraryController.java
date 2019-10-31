package com.ruoyi.web.controller.music;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.music.domain.MusicLibrary;
import com.ruoyi.music.service.IMusicLibraryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 音乐题库模块
 * 
 * @author linpq
 * @date 2019-10-31
 */
@Api("音乐题库")
@RestController
@RequestMapping("/music/library")
public class MusicLibraryController extends BaseController
{
    private String prefix = "music/library";

    @Autowired
    private IMusicLibraryService musicLibraryService;

    @RequiresPermissions("music:library:view")
    @GetMapping()
    public String library()
    {
        return prefix + "/library";
    }

    /**
     * 查询音乐题库列表
     */
    @RequiresPermissions("music:library:list")
    @PostMapping("/list")
    @ApiOperation("查询音乐题库列表")
    public TableDataInfo list(MusicLibrary musicLibrary)
    {
        startPage();
        List<MusicLibrary> list = musicLibraryService.selectMusicLibraryList(musicLibrary);
        return getDataTable(list);
    }

    /**
     * 导出音乐题库列表
     */
    @RequiresPermissions("music:library:export")
    @PostMapping("/export")
    @ApiImplicitParam(name = "musicLibrary", value = "", required = true, dataType = "MusicLibrary", paramType = "path")
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
    @RequiresPermissions("music:library:add")
    @Log(title = "音乐题库", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ApiImplicitParam(name = "musicLibrary", value = "新增保存音乐题库", required = true, dataType = "MusicLibrary")
    public AjaxResult addSave(MusicLibrary musicLibrary)
    {
        return toAjax(musicLibraryService.insertMusicLibrary(musicLibrary));
    }

    /**
     * 修改音乐题库
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
        MusicLibrary musicLibrary = musicLibraryService.selectMusicLibraryById(id);
        map.put("musicLibrary", musicLibrary);
        return prefix + "/edit";
    }

    /**
     * 修改保存音乐题库
     */
    @RequiresPermissions("music:library:edit")
    @Log(title = "音乐题库", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ApiImplicitParam(name = "musicLibrary", value = "修改保存音乐题库", required = true, dataType = "MusicLibrary")
    public AjaxResult editSave(MusicLibrary musicLibrary)
    {
        return toAjax(musicLibraryService.updateMusicLibrary(musicLibrary));
    }

    /**
     * 删除音乐题库
     */
    @RequiresPermissions("music:library:remove")
    @Log(title = "音乐题库", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ApiOperation("删除音乐题库")
    @ApiImplicitParam(name = "ids", value = "编号", required = true, dataType = "String", paramType = "path")
    public AjaxResult remove(String ids)
    {
        return toAjax(musicLibraryService.deleteMusicLibraryByIds(ids));
    }
}
