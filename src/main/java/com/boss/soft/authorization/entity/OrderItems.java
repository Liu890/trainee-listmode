package com.boss.soft.authorization.entity;

import lombok.Data;


import java.io.Serializable;

/**
 * @author 86430
 * @date 2020/7/15
 */
@Data
public class OrderItems implements Serializable{

    private Integer id;

    private Integer orderId;

    private String goodsName;

    private String specificationModel;

    private Integer quantity;

    private String location;

    private String dateTime;


    public OrderItems() {
    }

    public OrderItems(Integer id, Integer orderId, String goodsName, String specificationModel, Integer quantity, String location, String dateTime) {
        this.id = id;
        this.orderId = orderId;
        this.goodsName = goodsName;
        this.specificationModel = specificationModel;
        this.quantity = quantity;
        this.location = location;
        this.dateTime = dateTime;
    }

}
