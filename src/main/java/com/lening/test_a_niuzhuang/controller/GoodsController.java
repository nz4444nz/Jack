package com.lening.test_a_niuzhuang.controller;

import com.github.pagehelper.PageInfo;
import com.lening.test_a_niuzhuang.ResultInfo;
import com.lening.test_a_niuzhuang.entity.CityBean;
import com.lening.test_a_niuzhuang.entity.GoodsBean;
import com.lening.test_a_niuzhuang.service.GoodsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;
//全查
    @RequestMapping("/findAll")
    public PageInfo<GoodsBean> findAll(@RequestBody GoodsBean searchEntity,
                                       @RequestParam(defaultValue = "1") Integer pageNum,
                                       @RequestParam(defaultValue = "5") Integer pageSize){

        return goodsService.findALl(searchEntity,pageNum,pageSize);
    }
//批量删除
    @RequestMapping("/deleteBatch")
    public ResultInfo deleteBatch(@RequestBody Integer[] gids){
        try {
            goodsService.deleteBatch(gids);
            return new ResultInfo(true,"删除成功");
        } catch (Exception e) {
            return new ResultInfo(false,"删除失败");
        }
    }
//新增
    @RequestMapping("/insert")
    public ResultInfo insert(@RequestBody GoodsBean goodsBean){
        try {
            goodsService.insert(goodsBean);
            return new ResultInfo(true,"添加成功");
        } catch (Exception e) {
            return new ResultInfo(false,"添加失败");
        }
    }

//根据城市id查询(三级联动)
    @RequestMapping("/getCityListByPid")
    public List<CityBean> getCityListByPid(@RequestParam(defaultValue = "1") Long pid){
        return goodsService.getCityListByPid(pid);
    }


}
