package com.ruoyi.web.controller.music;

import java.util.List;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.music.domain.MusicItem;
import com.ruoyi.music.service.IMusicItemService;
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
 * 音乐试题Controller
 * 
 * @author linpq
 * @date 2019-10-27
 */
@Controller
@RequestMapping("/system/item")
public class MusicItemController extends BaseController
{
    private String prefix = "system/item";

    @Autowired
    private IMusicItemService musicItemService;

    @RequiresPermissions("system:item:view")
    @GetMapping()
    public String item()
    {
        return prefix + "/item";
    }

    /**
     * 查询音乐试题列表
     */
    @RequiresPermissions("system:item:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MusicItem musicItem)
    {
        startPage();
        List<MusicItem> list = musicItemService.selectMusicItemList(musicItem);
        return getDataTable(list);
    }

    /**
     * 导出音乐试题列表
     */
    @RequiresPermissions("system:item:export")
    @PostMapping("/export")
    @ResponseBody
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
    @RequiresPermissions("system:item:add")
    @Log(title = "音乐试题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MusicItem musicItem)
    {
        return toAjax(musicItemService.insertMusicItem(musicItem));
    }

    /**
     * 修改音乐试题
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        MusicItem musicItem = musicItemService.selectMusicItemById(id);
        mmap.put("musicItem", musicItem);
        return prefix + "/edit";
    }

    /**
     * 修改保存音乐试题
     */
    @RequiresPermissions("system:item:edit")
    @Log(title = "音乐试题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MusicItem musicItem)
    {
        return toAjax(musicItemService.updateMusicItem(musicItem));
    }

    /**
     * 删除音乐试题
     */
    @RequiresPermissions("system:item:remove")
    @Log(title = "音乐试题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(musicItemService.deleteMusicItemByIds(ids));
    }
}
