package com.ruoyi.web.controller.music;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.music.domain.MusicComment;
import com.ruoyi.music.service.IMusicCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 评论列模块
 * 
 * @author linpq
 * @date 2019-10-31
 */
@Api("评论列")
@RestController
@RequestMapping("/music/comment")
public class MusicCommentController extends BaseController
{
    private String prefix = "music/comment";

    @Autowired
    private IMusicCommentService musicCommentService;

    @RequiresPermissions("music:comment:view")
    @GetMapping()
    public String comment()
    {
        return prefix + "/comment";
    }

    /**
     * 查询评论列树列表
     */
    @RequiresPermissions("music:comment:list")
    @PostMapping("/list")
    @ApiOperation("查询评论列树列表")
    public List<MusicComment> list(MusicComment musicComment)
    {
        List<MusicComment> list = musicCommentService.selectMusicCommentList(musicComment);
        return list;
    }

    /**
     * 导出评论列列表
     */
    @RequiresPermissions("music:comment:export")
    @PostMapping("/export")
    @ApiImplicitParam(name = "musicComment", value = "", required = true, dataType = "MusicComment", paramType = "path")
    public AjaxResult export(MusicComment musicComment)
    {
        List<MusicComment> list = musicCommentService.selectMusicCommentList(musicComment);
        ExcelUtil<MusicComment> util = new ExcelUtil<MusicComment>(MusicComment.class);
        return util.exportExcel(list, "comment");
    }

    /**
     * 新增评论列
     */
    @GetMapping(value = { "/add/{id}", "/add/" })
    @ApiOperation("新增评论列")
    public String add(@PathVariable(value = "id", required = false) String id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("musicComment", musicCommentService.selectMusicCommentById(id));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存评论列
     */
    @RequiresPermissions("music:comment:add")
    @Log(title = "评论列", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ApiImplicitParam(name = "musicComment", value = "新增保存评论列", required = true, dataType = "MusicComment")
    public AjaxResult addSave(MusicComment musicComment)
    {
        return toAjax(musicCommentService.insertMusicComment(musicComment));
    }

    /**
     * 修改评论列
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
        MusicComment musicComment = musicCommentService.selectMusicCommentById(id);
        map.put("musicComment", musicComment);
        return prefix + "/edit";
    }

    /**
     * 修改保存评论列
     */
    @RequiresPermissions("music:comment:edit")
    @Log(title = "评论列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ApiImplicitParam(name = "musicComment", value = "修改保存评论列", required = true,dataType = "MusicComment")
    public AjaxResult editSave(MusicComment musicComment)
    {
        return toAjax(musicCommentService.updateMusicComment(musicComment));
    }

    /**
     * 删除
     */
    @RequiresPermissions("music:comment:remove")
    @Log(title = "评论列", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{id}")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataType = "String", paramType = "path")

    public AjaxResult remove(@PathVariable("id") String id)
    {
        return toAjax(musicCommentService.deleteMusicCommentById(id));
    }

    /**
     * 选择评论列树
     */
    @GetMapping(value = { "/selectCommentTree/{id}", "/selectCommentTree/" })
    public String selectCommentTree(@PathVariable(value = "id", required = false) String id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("musicComment", musicCommentService.selectMusicCommentById(id));
        }
        return prefix + "/tree";
    }

    /**
     * 加载评论列树列表
     */
    @GetMapping("/treeData")
    @ApiOperation("加载评论列树列表")
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = musicCommentService.selectMusicCommentTree();
        return ztrees;
    }
}
