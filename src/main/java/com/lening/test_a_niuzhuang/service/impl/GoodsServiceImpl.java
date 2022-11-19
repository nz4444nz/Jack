package com.lening.test_a_niuzhuang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lening.test_a_niuzhuang.entity.BrandBean;
import com.lening.test_a_niuzhuang.entity.CityBean;
import com.lening.test_a_niuzhuang.entity.GoodsBean;
import com.lening.test_a_niuzhuang.entity.SellerBean;
import com.lening.test_a_niuzhuang.mapper.BrandMapper;
import com.lening.test_a_niuzhuang.mapper.CityMapper;
import com.lening.test_a_niuzhuang.mapper.GoodsMapper;
import com.lening.test_a_niuzhuang.mapper.SellerMapper;
import com.lening.test_a_niuzhuang.service.GoodsService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private BrandMapper brandMapper;
    @Resource
    private SellerMapper sellerMapper;
    @Resource
    private CityMapper cityMapper;
    @Override
    public PageInfo<GoodsBean> findALl(GoodsBean searchEntity, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(GoodsBean.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchEntity != null){
            if (!StringUtils.isEmpty(searchEntity.getGname())){
                criteria.andLike("gname","%"+searchEntity.getGname()+"%");
            }
            if (searchEntity.getGprice()!=null){
                criteria.andGreaterThanOrEqualTo("gprice",searchEntity.getGprice());
            }
            if (searchEntity.getEprice()!=null){
                criteria.andLessThanOrEqualTo("gprice",searchEntity.getEprice());
            }
        }
        List<GoodsBean> list = goodsMapper.selectByExample(example);
        for (GoodsBean goodsBean : list) {
            if (goodsBean.getBid()!=null){
                BrandBean brandBean = brandMapper.selectByPrimaryKey(goodsBean.getBid());
                goodsBean.setBb(brandBean);
            }
            if (goodsBean.getSid()!=null){
                SellerBean sellerBean = sellerMapper.selectByPrimaryKey(goodsBean.getSid());
                System.out.println(sellerBean);
                goodsBean.setSb(sellerBean);
            }
        }
        PageInfo<GoodsBean> pageinfo = new PageInfo<>(list);
        return pageinfo;
    }

    @Override
    public void deleteBatch(Integer[] gids) {
        if (gids!=null&&gids.length>=1){
            for (Integer gid : gids) {
                goodsMapper.deleteByPrimaryKey(gid);
            }
        }
    }

    @Override
    public void insert(GoodsBean goodsBean) {
        if (goodsBean!= null){
            goodsMapper.insertSelective(goodsBean);
        }
    }

    @Override
    public List<CityBean> getCityListByPid(Long pid) {
        Example example = new Example(CityBean.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("pid", pid);
        return cityMapper.selectByExample(example);
    }
}
