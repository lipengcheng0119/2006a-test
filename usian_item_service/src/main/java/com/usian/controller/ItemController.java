package com.usian.controller;

import com.usian.service.ItemService;
import com.usian.utils.PageResult;
import com.usian.utils.Result;
import com.usian.vo.ItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/item/")
public class ItemController {
    @Autowired
    private ItemService itemService;
    //查询展示
    @RequestMapping("/selectTbItemAllByPage")
    PageResult selectTbItemAllByPage(@RequestParam(name = "page")Integer page, @RequestParam(name = "rows")Integer rows){
        return itemService.selectTbItemAllByPage(page,rows);
    }
    //添加商品Item
    @RequestMapping("/insertTbItem")
    void insertTbItem(@RequestBody ItemVo itemVo){
         itemService.insertTbItem(itemVo);
    }
    //删除商品Item
    @RequestMapping("/deleteItemById")
    public void deleteItemById(@RequestParam("itemId")Long itemId){
        itemService.deleteItemById(itemId);
    }
    //预更新商品Item回显
    @RequestMapping("/preUpdateItem")
    public Map<String ,Object> preUpdateItem(@RequestParam("itemId")Long itemId){
        return itemService.preUpdateItem(itemId);
    }
    //商品修改
    @RequestMapping("/updateTbItem")
    public void updateTbItem(@RequestBody ItemVo itemVo){
        itemService.updateTbItem(itemVo);
    }

}
