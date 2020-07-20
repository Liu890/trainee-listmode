package com.boss.soft.authorization.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 86430
 * @date 2020/7/15
 */
@Data
public class Order implements Serializable {

    private Integer orderId;

    private String startDate;

    private Integer status;

    private Integer employeeId;

    private String endDate;

    public Order() {
    }

    public Order(Integer orderId, String startDate, Integer status, Integer employeeId, String endDate) {
        this.orderId = orderId;
        this.startDate = startDate;
        this.status = status;
        this.employeeId = employeeId;
        this.endDate = endDate;
    }


}
