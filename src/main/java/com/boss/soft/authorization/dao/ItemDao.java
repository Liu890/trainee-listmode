package com.boss.soft.authorization.dao;

import com.boss.soft.authorization.entity.OrderItems;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 86430
 * @date 2020/7/16
 */
@Repository
public interface ItemDao {
    /**
     *find all
     * @param
     * @return Result <OrderItems>
     */
    List<OrderItems> itemsList();

    /**
     *find by orderId
     * @param orderId
     * @return Result <OrderItems>
     */
    List<OrderItems> findById(Integer orderId);

    /**
     *add orderItems
     * @param orderItems
     * @return
     */
    void addItems(OrderItems orderItems);
}
