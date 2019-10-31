package com.ruoyi.web.controller.music;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.music.domain.MusicMember;
import com.ruoyi.music.service.IMusicMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 音乐会员模块
 * 
 * @author echoyu
 * @date 2019-10-31
 */
@Api("音乐会员")
@RestController
@RequestMapping("/music/member")
public class MusicMemberController extends BaseController
{
    private String prefix = "music/member";

    @Autowired
    private IMusicMemberService musicMemberService;

    @RequiresPermissions("music:member:view")
    @GetMapping()
    public String member()
    {
        return prefix + "/member";
    }

    /**
     * 查询音乐会员列表
     */
    @RequiresPermissions("music:member:list")
    @PostMapping("/list")
    @ApiOperation("查询音乐会员列表")
    public TableDataInfo list(MusicMember musicMember)
    {
        startPage();
        List<MusicMember> list = musicMemberService.selectMusicMemberList(musicMember);
        return getDataTable(list);
    }

    /**
     * 导出音乐会员列表
     */
    @RequiresPermissions("music:member:export")
    @PostMapping("/export")
    @ApiImplicitParam(name = "musicMember", value = "", required = true, dataType = "MusicMember", paramType = "path")
    public AjaxResult export(MusicMember musicMember)
    {
        List<MusicMember> list = musicMemberService.selectMusicMemberList(musicMember);
        ExcelUtil<MusicMember> util = new ExcelUtil<MusicMember>(MusicMember.class);
        return util.exportExcel(list, "member");
    }

    /**
     * 新增音乐会员
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存音乐会员
     */
    @RequiresPermissions("music:member:add")
    @Log(title = "音乐会员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ApiImplicitParam(name = "musicMember", value = "新增保存音乐会员", required = true, dataType = "MusicMember")
    public AjaxResult addSave(MusicMember musicMember)
    {
        return toAjax(musicMemberService.insertMusicMember(musicMember));
    }

    /**
     * 修改音乐会员
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
        MusicMember musicMember = musicMemberService.selectMusicMemberById(id);
        map.put("musicMember", musicMember);
        return prefix + "/edit";
    }

    /**
     * 修改保存音乐会员
     */
    @RequiresPermissions("music:member:edit")
    @Log(title = "音乐会员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ApiImplicitParam(name = "musicMember", value = "修改保存音乐会员", required = true, dataType = "MusicMember")
    public AjaxResult editSave(MusicMember musicMember)
    {
        return toAjax(musicMemberService.updateMusicMember(musicMember));
    }

    /**
     * 删除音乐会员
     */
    @RequiresPermissions("music:member:remove")
    @Log(title = "音乐会员", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ApiOperation("删除音乐会员")
    @ApiImplicitParam(name = "ids", value = "编号", required = true, dataType = "String", paramType = "path")
    public AjaxResult remove(String ids)
    {
        return toAjax(musicMemberService.deleteMusicMemberByIds(ids));
    }
}
