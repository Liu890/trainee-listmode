package com.boss.soft.authorization.entity;

import lombok.Data;

import java.io.Serializable;


/**
 * @author 86430
 * @date 2020/7/15
 */
@Data
public class Employee implements Serializable {

    private Integer employeeId;

    private String employeeName;

    private String departmentName;

    public Employee() {
    }

    public Employee(Integer employeeId, String employeeName, String departmentName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.departmentName = departmentName;
    }

}
