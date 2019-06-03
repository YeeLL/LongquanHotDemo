package com.longquanhot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.longquanhot.pojo.TbItem;
import com.longquanhot.service.ItemCatService;
import com.longquanhot.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.DataGridResult;
import pojo.DataTreeNode;

import java.util.List;

/**
 * 商品页面
 */
@RestController
public class ItemController {

    @Autowired
    ItemService itemService;



    /**
     * 获取某一个商品详情
     *
     * @param id 商品ID
     * @return
     */
    @RequestMapping("/item/{id}")
    public TbItem getItemById(@PathVariable(value = "id") long id) {
        return itemService.getItemById(id);
    }

    /**
     * 分页获取商品列表
     *
     * @param page 页号 从1开始
     * @param rows 每页页数
     * @return
     */
    @RequestMapping("/item/list")
    public DataGridResult getItemListByPage(Integer page, Integer rows) {
        return itemService.getItemListByPage(page, rows);
    }



}
