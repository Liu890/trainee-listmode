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

    /**
     * <p>
     *  找出单子具体的细节
     * </p>
     * @date 2020-07-21
     * @param orderId
     * @Return Result <List<OrderItems>
     */
    List<OrderItems> findByOrderId(Integer orderId);

}
