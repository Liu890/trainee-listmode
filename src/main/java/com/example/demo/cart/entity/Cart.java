package com.example.demo.cart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

/**
 * @author 86430
 * @date 2020/7/21
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    private Integer id;

    private Employee employee;

    private List<OrderList> orderList;

    private List<OrderItems> orderItems;
}
