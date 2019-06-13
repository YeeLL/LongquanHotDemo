package com.longquanhot.controller;

import com.longquanhot.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.DataTreeNode;

import java.util.List;

/**
 * 商品分类列表
 */
@RestController
@RequestMapping("/item/cat/")
public class ItemCatController {
    @Autowired
    ItemCatService itemCatService;

    @RequestMapping("list")
    public List<DataTreeNode> getCatList(@RequestParam(name = "id",defaultValue = "0") Integer id) {
        return itemCatService.getItemCatList(id);
    }
}
