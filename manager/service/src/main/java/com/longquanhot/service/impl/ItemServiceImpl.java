package com.longquanhot.service.impl;

import com.longquanhot.pojo.TbItem;
import com.longquanhot.mapper.TbItemMapper;
import com.longquanhot.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品管理service
 * 1.将服务提供者注册到注册中心（暴露）
 *    1.导入dubbo依赖  2.6.2版本
 *
 * 2.让服务消费者去注册中心订阅服务提供的服务地址
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    TbItemMapper itemMapper;

    /**
     * 通过商品id获取商品详细信息
     * @param id
     * @return
     */
    public TbItem getItemById(Long id) {
        return itemMapper.selectByPrimaryKey(id);
    }
}
