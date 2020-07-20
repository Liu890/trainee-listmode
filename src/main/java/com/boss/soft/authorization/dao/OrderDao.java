package com.boss.soft.authorization.dao;

import com.boss.soft.authorization.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 86430
 * @date 2020/7/16
 */
@Repository
public interface OrderDao {
    /**
     *
     * find all
     *
     * @param
     *
     * @return Result <Order>
     */
    List<Order> orderList();

    /**
     *
     * find by orderId
     *
     * @param employeeId
     *
     * @return Result <Order>
     */
    List<Order> findById(Integer employeeId);

    /**
     *
     * add order
     *
     * @param order
     *
     * @return null
     */
    void addOrder(Order order);
}
