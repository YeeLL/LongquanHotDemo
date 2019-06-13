package com.longquanhot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.longquanhot.mapper.TbItemCatMapper;
import com.longquanhot.mapper.TbItemDescMapper;
import com.longquanhot.mapper.TbItemMapper;
import com.longquanhot.pojo.TbItem;
import com.longquanhot.pojo.TbItemDesc;
import com.longquanhot.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.BaseResult;
import pojo.DataGridResult;

import java.util.*;

/**
 * 商品管理service
 * 1.将服务提供者注册到注册中心（暴露）
 * 1.导入dubbo依赖  2.6.2版本
 * <p>
 * 2.让服务消费者去注册中心订阅服务提供的服务地址
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    TbItemMapper itemMapper;

    @Autowired
    TbItemCatMapper catMapper;

    @Autowired
    TbItemDescMapper descMapper;

    /**
     * 通过商品id获取商品详细信息
     *
     * @param id
     * @return
     */
    public TbItem getItemById(Long id) {
        return itemMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页获取 商品列表
     *
     * @param page
     * @return
     */
    public DataGridResult getItemListByPage(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<TbItem> data = itemMapper.selectByPage();
        PageInfo<TbItem> list = new PageInfo<TbItem>(data);

        DataGridResult dataGridResult = new DataGridResult();
        dataGridResult.setTotal(list.getSize());
        dataGridResult.setRows(list.getList());
        return dataGridResult;
    }

    /**
     * 删除商品
     *
     * @param ids
     * @return
     */
    public HashMap<String, Object> delete(String[] ids) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        try {
            for (String id : ids) {
                itemMapper.deleteByPrimaryKey(new Long(id));
            }
            hashMap.put("status", 200);
            return hashMap;
        } catch (Exception e) {
            hashMap.put("status", 400);
            return hashMap;
        }
    }

    /**
     * 通过商品ID 获取商品描述
     *
     * @param id
     * @return
     */
    public BaseResult queryItemDesc(Long id) {
        System.out.println("----------queryItemDesc----" + id);
        TbItemDesc desc = descMapper.selectByPrimaryKey(id);
        return new BaseResult(200, "success", desc.getItemDesc());
    }

    /**
     * 下架商品
     *
     * @param strs
     * @return
     */
    public BaseResult instock(String[] strs) {
        for (String s:strs) {
            TbItem item = itemMapper.selectByPrimaryKey(new Long(s));
            item.setUpdated(new Date());
            item.setStatus((byte)2);
            itemMapper.updateByPrimaryKey(item);
        }
        return new BaseResult(200,"success",null);
    }

    /**
     * 上架商品
     *
     * @param strs
     * @return
     */
    public BaseResult reshelf(String[] strs) {
        for (String s:strs) {
            TbItem item = itemMapper.selectByPrimaryKey(new Long(s));
            item.setUpdated(new Date());
            item.setStatus((byte)1);
            itemMapper.updateByPrimaryKey(item);
        }
        return new BaseResult(200,"success",null);
    }

}
