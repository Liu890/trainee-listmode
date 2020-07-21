package com.example.demo.cart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.cart.entity.OrderItems;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljx
 * @since 2020-07-21
 */
public interface IOrderItemsService extends IService<OrderItems> {

    List<OrderItems> findByOrderId(Integer orderId);

}
