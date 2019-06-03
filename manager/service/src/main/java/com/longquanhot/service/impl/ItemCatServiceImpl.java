package com.longquanhot.service.impl;

import com.longquanhot.mapper.TbItemCatMapper;
import com.longquanhot.pojo.TbItemCat;
import com.longquanhot.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.DataTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类管理
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    TbItemCatMapper catMapper;

    /**
     * 根据父节点查询所有子节点
     * @param parentId
     * @return
     */
    public List<DataTreeNode> getItemCatList(long parentId) {
        ///根据parentid 查询子节点
        List<TbItemCat> list = catMapper.selectCatItemList(parentId);

        List<DataTreeNode> dataTreeNodes = new ArrayList<DataTreeNode>();

        for (TbItemCat cat : list) {
            DataTreeNode dataTreeNode = new DataTreeNode();
            dataTreeNode.setId(cat.getId().intValue());
            dataTreeNode.setState(cat.getIsParent() ? "closed" : "open");
            dataTreeNode.setText(cat.getName());
            dataTreeNodes.add(dataTreeNode);
        }

        return dataTreeNodes;
    }
}
