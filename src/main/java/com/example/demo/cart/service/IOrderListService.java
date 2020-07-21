package com.example.demo.cart.service;

import com.example.demo.cart.entity.OrderList;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljx
 * @since 2020-07-21
 */
public interface IOrderListService extends IService<OrderList> {

    /**
     * <p>
     *  根据员工编号查找对应的单子
     * </p>
     *
     * @param employeeId
     * @Return Result <List<OrderList>
     */
    List<OrderList> findByEmployeeId(Integer employeeId);
}
