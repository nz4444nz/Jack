package com.lening.test_a_niuzhuang.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "tb_seller")
@Entity
@Data
public class SellerBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;
    private String sname;
}
