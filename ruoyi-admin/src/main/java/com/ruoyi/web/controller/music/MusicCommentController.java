package com.ruoyi.web.controller.music;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.music.domain.MusicComment;
import com.ruoyi.music.service.IMusicCommentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 评论列Controller
 *
 * @author linpq
 * @date 2019-10-27
 */
@Controller
@RequestMapping("/system/comment")
public class MusicCommentController extends BaseController {
    private String prefix = "system/comment";

    @Autowired
    private IMusicCommentService musicCommentService;

    @RequiresPermissions("system:comment:view")
    @GetMapping()
    public String comment() {
        return prefix + "/comment";
    }

    /**
     * 查询评论列列表
     */
    @RequiresPermissions("system:comment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MusicComment musicComment) {
        startPage();
        List<MusicComment> list = musicCommentService.selectMusicCommentList(musicComment);
        return getDataTable(list);
    }

    /**
     * 导出评论列列表
     */
    @RequiresPermissions("system:comment:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MusicComment musicComment) {
        List<MusicComment> list = musicCommentService.selectMusicCommentList(musicComment);
        ExcelUtil<MusicComment> util = new ExcelUtil<MusicComment>(MusicComment.class);
        return util.exportExcel(list, "comment");
    }

    /**
     * 新增评论列
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存评论列
     */
    @RequiresPermissions("system:comment:add")
    @Log(title = "评论列", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MusicComment musicComment) {
        return toAjax(musicCommentService.insertMusicComment(musicComment));
    }

    /**
     * 修改评论列
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        MusicComment musicComment = musicCommentService.selectMusicCommentById(id);
        mmap.put("musicComment", musicComment);
        return prefix + "/edit";
    }

    /**
     * 修改保存评论列
     */
    @RequiresPermissions("system:comment:edit")
    @Log(title = "评论列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MusicComment musicComment) {
        return toAjax(musicCommentService.updateMusicComment(musicComment));
    }

    /**
     * 删除评论列
     */
    @RequiresPermissions("system:comment:remove")
    @Log(title = "评论列", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(musicCommentService.deleteMusicCommentByIds(ids));
    }
}
