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
 * 表单
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
public class OrderList implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    private String startDate;

    /**
     * 状态；已采买：1；正在进行：0
     */
    private Integer status;

    private Integer employeeId;

    private String endDate;


}
