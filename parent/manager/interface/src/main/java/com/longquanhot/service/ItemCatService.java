package com.longquanhot.service;

import pojo.DataTreeNode;

import java.util.List;

/**
 * 商品类目
 */
public interface ItemCatService {

    List<DataTreeNode> getItemCatList(long parentId);
}
