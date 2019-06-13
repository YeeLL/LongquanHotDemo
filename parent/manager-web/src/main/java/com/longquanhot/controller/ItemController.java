package com.longquanhot.controller;

import com.longquanhot.pojo.TbItem;
import com.longquanhot.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.BaseResult;
import pojo.DataGridResult;

import java.util.HashMap;

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


    /**
     * 删除商品  支持多个删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/rest/item/delete")
    public HashMap<String, Object> deleteItemById(String ids) {
        String[] strs = ids.split(",");
        return itemService.delete(strs);
    }

    /**
     * 通过商品ID获取商品描述
     *
     * @param id
     * @return
     */
    @RequestMapping("/rest/item/query/item/desc/{id}")
    public BaseResult queryItemDesc(@PathVariable("id") long id) {
        return itemService.queryItemDesc(id);
    }

    /**
     * 下架商品
     */
    @RequestMapping("/rest/item/instock")
    public BaseResult instock(String ids){
        String[] strs = ids.split(",");
        return itemService.instock(strs);
    }

    /**
     * 上架商品
     * @param ids
     * @return
     */
    @RequestMapping("/rest/item/reshelf")
    public  BaseResult reshelf(String ids){
        String[] strs = ids.split(",");
        return itemService.reshelf(strs);
    }
    @Test
    public void test() {
        String ids = "1";
        String[] strs = ids.split(",");
        for (String id : strs) {
            System.out.println(new Long(id));
        }
    }

}
