package com.longquanhot.mapper;

import com.longquanhot.pojo.TbItemCat;

import java.util.List;

/**
 * 商品类型
 */
public interface TbItemCatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItemCat record);

    int insertSelective(TbItemCat record);

    TbItemCat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItemCat record);

    int updateByPrimaryKey(TbItemCat record);
    List<TbItemCat> selectCatItemList(Long parentId);


}