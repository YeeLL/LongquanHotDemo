package com.longquanhot.service;

import com.longquanhot.pojo.TbItem;

/**
 * 提供商品查询服务
 */
public interface ItemService {
    public TbItem getItemById(Long id);
}
