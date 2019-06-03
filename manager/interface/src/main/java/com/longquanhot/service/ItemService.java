package com.longquanhot.service;

import com.longquanhot.pojo.TbItem;
import pojo.DataGridResult;
import pojo.DataTreeNode;

import java.util.*;

/**
 * 提供商品查询服务
 */
public interface ItemService {
    TbItem getItemById(Long id);

    DataGridResult getItemListByPage(Integer page, Integer rows);

}
