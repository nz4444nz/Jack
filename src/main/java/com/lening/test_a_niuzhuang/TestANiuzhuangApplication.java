package com.lening.test_a_niuzhuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.lening.test_a_niuzhuang.mapper")
public class TestANiuzhuangApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestANiuzhuangApplication.class, args);
    }

}
