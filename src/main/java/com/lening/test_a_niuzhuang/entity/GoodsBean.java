package com.lening.test_a_niuzhuang.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "tb_goods")
@Entity
@Data
public class GoodsBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    private String gname;
    private Double gprice;
    @Transient
    private Double eprice;
    private String gaddress;

    private Integer bid;
    private Integer sid;
    @Transient
    private BrandBean bb = new BrandBean();
    @Transient
    private SellerBean sb = new SellerBean();
}
