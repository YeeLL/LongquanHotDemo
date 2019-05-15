package com.longquanhot.controller;

import com.longquanhot.pojo.TbItem;
import com.longquanhot.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品页面
 */
@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping("/item/{id}")
    public TbItem getItemById(@PathVariable(value = "id") long id) {
        return itemService.getItemById(id);
    }
}
