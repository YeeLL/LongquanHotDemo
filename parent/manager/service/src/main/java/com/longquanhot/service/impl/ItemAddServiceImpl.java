package com.longquanhot.service.impl;

import com.longquanhot.mapper.TbItemDescMapper;
import com.longquanhot.mapper.TbItemMapper;
import com.longquanhot.pojo.TbItem;
import com.longquanhot.pojo.TbItemDesc;
import com.longquanhot.service.ItemAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.BaseResult;

import java.util.Date;
import java.util.Random;

/**
 * 添加商品
 */
@Service
public class ItemAddServiceImpl implements ItemAddService {
    @Autowired
    TbItemMapper itemMapper;
    @Autowired
    TbItemDescMapper descMapper;


    /**
     * 添加商品
     *
     * @param tbItem 商品信息
     * @return
     */
    public BaseResult addItem(TbItem tbItem, String desc) {
        if (tbItem == null) {
            return new BaseResult(400, "faild", null);
        }
        long id = createItemId();
        //todo 做一些校验

        tbItem.setId(id);
        tbItem.setCreated(new Date());
        tbItem.setStatus((byte) 1);
        tbItem.setUpdated(new Date());
        itemMapper.insert(tbItem);

        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setItemId(id);
        tbItemDesc.setCreated(new Date());
        tbItemDesc.setUpdated(new Date());
        descMapper.insert(tbItemDesc);
        return new BaseResult(tbItem);
    }

    /**
     * 更新商品
     *
     * @param itemDetailDto
     * @param desc
     * @return
     */
    public BaseResult updateItem(TbItem itemDetailDto, String desc) {
        itemDetailDto.setStatus((byte)1);
        itemDetailDto.setUpdated(new Date());
        itemDetailDto.setCreated(new Date());
        itemMapper.updateByPrimaryKey(itemDetailDto);
        TbItemDesc descDao = descMapper.selectByPrimaryKey(itemDetailDto.getId());

        descDao.setItemDesc(desc);
        descDao.setUpdated(new Date());

        descMapper.updateByPrimaryKey(descDao);
        return new BaseResult(itemDetailDto);
    }


    /**
     * 创建一个不重复的商品id
     *
     * @return
     */
    public long createItemId() {
        long millis = System.currentTimeMillis();
        Random random = new Random();
        int end2 = random.nextInt(99);
        String str = millis + String.format("%02d", end2);
        long id = new Long(str);
        return id;
    }
}
