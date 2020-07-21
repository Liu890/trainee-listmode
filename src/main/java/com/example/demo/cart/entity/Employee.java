package com.example.demo.cart.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * <p>
 * 员工类
 * </p>
 *
 * @author ljx
 * @since 2020-07-21
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Employee implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "employee_id", type = IdType.AUTO)
    private Integer employeeId;

    private String employeeName;

    private String departmentName;


}
