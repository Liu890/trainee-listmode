package com.boss.soft.authorization.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 86430
 * @date 2020/7/15
 */
@Data
public class Cart implements Serializable {

    private Integer id;

    private Employee employee;

    private Order order;

    private List<OrderItems> orderItems;

    public Cart() {
    }


}
