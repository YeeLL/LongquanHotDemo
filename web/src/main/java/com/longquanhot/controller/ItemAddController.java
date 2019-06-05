package com.longquanhot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.ItemDetailDto;

import java.util.HashMap;

/**
 * 商品添加
 */
@RequestMapping("/item/")
@RestController
public class ItemAddController {


    @RequestMapping("save")
    public HashMap<String, Object> saveItem(ItemDetailDto itemDetailDto) {

        return null;
    }

}
