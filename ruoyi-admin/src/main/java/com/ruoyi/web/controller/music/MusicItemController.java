package com.ruoyi.web.controller.music;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.music.domain.MusicItem;
import com.ruoyi.music.service.IMusicItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 音乐试题模块
 * 
 * @author linpq
 * @date 2019-10-31
 */
@Api("音乐试题")
@RestController
@RequestMapping("/music/item")
public class MusicItemController extends BaseController
{
    private String prefix = "music/item";

    @Autowired
    private IMusicItemService musicItemService;

    @RequiresPermissions("music:item:view")
    @GetMapping()
    public String item()
    {
        return prefix + "/item";
    }

    /**
     * 查询音乐试题列表
     */
    @RequiresPermissions("music:item:list")
    @PostMapping("/list")
    @ApiOperation("查询音乐试题列表")
    public TableDataInfo list(MusicItem musicItem)
    {
        startPage();
        List<MusicItem> list = musicItemService.selectMusicItemList(musicItem);
        return getDataTable(list);
    }

    /**
     * 导出音乐试题列表
     */
    @RequiresPermissions("music:item:export")
    @PostMapping("/export")
    @ApiImplicitParam(name = "musicItem", value = "", required = true, dataType = "MusicItem", paramType = "path")
    public AjaxResult export(MusicItem musicItem)
    {
        List<MusicItem> list = musicItemService.selectMusicItemList(musicItem);
        ExcelUtil<MusicItem> util = new ExcelUtil<MusicItem>(MusicItem.class);
        return util.exportExcel(list, "item");
    }

    /**
     * 新增音乐试题
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存音乐试题
     */
    @RequiresPermissions("music:item:add")
    @Log(title = "音乐试题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ApiImplicitParam(name = "musicItem", value = "新增保存音乐试题", required = true, dataType = "MusicItem")
    public AjaxResult addSave(MusicItem musicItem)
    {
        return toAjax(musicItemService.insertMusicItem(musicItem));
    }

    /**
     * 修改音乐试题
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
        MusicItem musicItem = musicItemService.selectMusicItemById(id);
        map.put("musicItem", musicItem);
        return prefix + "/edit";
    }

    /**
     * 修改保存音乐试题
     */
    @RequiresPermissions("music:item:edit")
    @Log(title = "音乐试题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ApiImplicitParam(name = "musicItem", value = "修改保存音乐试题",required = true,dataType = "MusicItem")
    public AjaxResult editSave(MusicItem musicItem)
    {
        return toAjax(musicItemService.updateMusicItem(musicItem));
    }

    /**
     * 删除音乐试题
     */
    @RequiresPermissions("music:item:remove")
    @Log(title = "音乐试题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ApiOperation("删除音乐试题")
    @ApiImplicitParam(name = "ids", value = "编号", required = true, dataType = "String", paramType = "path")
    public AjaxResult remove(String ids)
    {
        return toAjax(musicItemService.deleteMusicItemByIds(ids));
    }
}
