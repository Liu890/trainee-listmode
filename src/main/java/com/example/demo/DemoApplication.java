package com.example.demo;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author 86430
 * @date 2020/7/21
 */
@SpringBootApplication
@MapperScan("com.example.demo.cart.mapper")
public class DemoApplication {

    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


}
