package com.lening.test_a_niuzhuang.service;

import com.github.pagehelper.PageInfo;
import com.lening.test_a_niuzhuang.entity.CityBean;
import com.lening.test_a_niuzhuang.entity.GoodsBean;

import java.util.List;

public interface GoodsService {

    PageInfo<GoodsBean> findALl(GoodsBean searchEntity, Integer pageNum, Integer pageSize);

    void deleteBatch(Integer[] gids);

    void insert(GoodsBean goodsBean);

    List<CityBean> getCityListByPid(Long pid);
}
