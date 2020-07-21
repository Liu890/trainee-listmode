package com.example.demo.cart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.cart.entity.OrderItems;
import com.example.demo.cart.mapper.OrderItemsMapper;
import com.example.demo.cart.service.IOrderItemsService;
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
public class OrderItemsServiceImpl extends ServiceImpl<OrderItemsMapper, OrderItems> implements IOrderItemsService {

    @Autowired
    OrderItemsMapper orderItemsMapper;

    @Override
    public List<OrderItems> findByOrderId(Integer orderId){
        List<OrderItems> itemsList = orderItemsMapper.findByOrderId(orderId);
        return itemsList;
    }
}
