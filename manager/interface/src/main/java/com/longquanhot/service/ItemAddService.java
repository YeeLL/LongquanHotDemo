package com.longquanhot.service;

import pojo.ItemDetailDto;

import java.util.HashMap;

/**
 * 商品添加
 */
public interface ItemAddService {

    /**
     * 添加商品
     * @param itemDetailDto 商品信息
     * @return
     */
    HashMap<String, Object> addItem(ItemDetailDto itemDetailDto);
}
