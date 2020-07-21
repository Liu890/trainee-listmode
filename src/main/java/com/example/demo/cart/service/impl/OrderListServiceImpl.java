package com.example.demo.cart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.cart.entity.OrderList;
import com.example.demo.cart.mapper.OrderListMapper;
import com.example.demo.cart.service.IOrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljx
 * @since 2020-07-21
 */
@Service
public class OrderListServiceImpl extends ServiceImpl<OrderListMapper, OrderList> implements IOrderListService {

    @Autowired
    OrderListMapper orderListMapper;

    @Override
    public List<OrderList> findByEmployeeId(Integer employeeId){
        List<OrderList> orderLists = orderListMapper.findByEmployeeId(employeeId);
        return orderLists;
    }

}
