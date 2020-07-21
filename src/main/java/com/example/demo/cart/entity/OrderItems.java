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
 * 表单细节
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
public class OrderItems implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer orderId;

    private String goodsName;

    /**
     * 规格型号
     */
    private String specificationModel;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 用途地点
     */
    private String location;

    /**
     * 需要时间
     */
    private String datetime;


}
