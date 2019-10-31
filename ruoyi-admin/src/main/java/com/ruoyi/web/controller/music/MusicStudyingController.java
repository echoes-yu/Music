package com.ruoyi.web.controller.music;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.music.domain.MusicStudying;
import com.ruoyi.music.service.IMusicStudyingService;
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
 * 成员学习记录模块
 * 
 * @author echoyu
 * @date 2019-10-31
 */
@Api("成员学习记录")
@Controller
@RequestMapping("/music/studying")
public class MusicStudyingController extends BaseController
{
    private String prefix = "music/studying";

    @Autowired
    private IMusicStudyingService musicStudyingService;

    @RequiresPermissions("music:studying:view")
    @GetMapping()
    public String studying()
    {
        return prefix + "/studying";
    }

    /**
     * 查询成员学习记录列表
     */
    @RequiresPermissions("music:studying:list")
    @PostMapping("/list")
    @ApiOperation("查询成员学习记录列表")
    @ResponseBody
    public TableDataInfo list(MusicStudying musicStudying)
    {
        startPage();
        List<MusicStudying> list = musicStudyingService.selectMusicStudyingList(musicStudying);
        return getDataTable(list);
    }

    /**
     * 导出成员学习记录列表
     */
    @RequiresPermissions("music:studying:export")
    @PostMapping("/export")
    @ApiOperation("导出成员学习记录")
    @ResponseBody
    public AjaxResult export(MusicStudying musicStudying)
    {
        List<MusicStudying> list = musicStudyingService.selectMusicStudyingList(musicStudying);
        ExcelUtil<MusicStudying> util = new ExcelUtil<MusicStudying>(MusicStudying.class);
        return util.exportExcel(list, "studying");
    }

    /**
     * 新增成员学习记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存成员学习记录
     */
    @RequiresPermissions("music:studying:add")
    @Log(title = "成员学习记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ApiOperation("新增保存成员学习记录")
    @ResponseBody
    public AjaxResult addSave(MusicStudying musicStudying)
    {
        return toAjax(musicStudyingService.insertMusicStudying(musicStudying));
    }

    /**
     * 修改成员学习记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
        MusicStudying musicStudying = musicStudyingService.selectMusicStudyingById(id);
        map.put("musicStudying", musicStudying);
        return prefix + "/edit";
    }

    /**
     * 修改保存成员学习记录
     */
    @RequiresPermissions("music:studying:edit")
    @Log(title = "成员学习记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ApiImplicitParam(name = "musicStudying", value = "修改保存成员学习记录", required = true,dataType = "MusicStudying")
    public AjaxResult editSave(MusicStudying musicStudying)
    {
        return toAjax(musicStudyingService.updateMusicStudying(musicStudying));
    }

    /**
     * 删除成员学习记录
     */
    @RequiresPermissions("music:studying:remove")
    @Log(title = "成员学习记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ApiOperation("删除成员学习记录")
    public AjaxResult remove(String ids)
    {
        return toAjax(musicStudyingService.deleteMusicStudyingByIds(ids));
    }
}
