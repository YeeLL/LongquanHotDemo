package com.longquanhot.service;

import com.longquanhot.pojo.TbItem;
import pojo.BaseResult;

/**
 * 商品添加
 */
public interface ItemAddService {

    /**
     * 添加商品
     *
     * @param itemDetailDto 商品信息
     * @return
     */
    BaseResult addItem(TbItem itemDetailDto, String desc);

    /**
     * 更新商品
     *
     * @param itemDetailDto
     * @param desc
     * @return
     */
    BaseResult updateItem(TbItem itemDetailDto, String desc);
}
