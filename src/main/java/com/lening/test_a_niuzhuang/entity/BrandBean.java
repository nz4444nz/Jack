package com.lening.test_a_niuzhuang.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "tb_brand")
@Entity
@Data
public class BrandBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bname;

}
