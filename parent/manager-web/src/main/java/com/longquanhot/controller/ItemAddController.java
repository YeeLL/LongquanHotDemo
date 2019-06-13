package com.longquanhot.controller;

import com.longquanhot.pojo.TbItem;
import com.longquanhot.service.ItemAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.BaseResult;


/**
 * 商品添加
 */
@RestController
public class ItemAddController {

    @Autowired
    ItemAddService itemAddService;

    @RequestMapping("/item/save")
    public BaseResult saveItem(TbItem item, String desc) {
        return itemAddService.addItem(item,desc);
    }

    @RequestMapping("/rest/item/update")
    public BaseResult updateItem(TbItem item,String desc){
        return itemAddService.updateItem(item,desc);
    }

}
