package com.longquanhot.service;

import com.longquanhot.pojo.TbItem;
import pojo.BaseResult;
import pojo.DataGridResult;

import java.util.*;

/**
 * 提供商品查询服务
 */
public interface ItemService {
    TbItem getItemById(Long id);

    DataGridResult getItemListByPage(Integer page, Integer rows);

    HashMap<String, Object> delete(String[] ids);

    BaseResult queryItemDesc(Long id);

    /**
     * 商品下架
     *
     * @param strs
     * @return
     */
    BaseResult instock(String[] strs);

    /**
     * 商品上架
     *
     * @param strs
     * @return
     */
    BaseResult reshelf(String[] strs);
}
