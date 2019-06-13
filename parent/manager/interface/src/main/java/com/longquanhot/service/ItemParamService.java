package com.longquanhot.service;

import pojo.BaseResult;
import pojo.DataGridResult;

import java.util.HashMap;

/**
 * 商品规格参数
 */
public interface ItemParamService {

    DataGridResult selectParamPageList();

    HashMap<String, Object> delete(String[] ids);


    BaseResult update();

    BaseResult add();

}
