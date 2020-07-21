package com.example.demo.cart.mapper;

import com.example.demo.cart.entity.OrderList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ljx
 * @since 2020-07-21
 */
@Component
public interface OrderListMapper extends BaseMapper<OrderList> {

    /**
     *
     * find by orderId
     *
     * @param employeeId
     *
     * @return Result <Order>
     */
    List<OrderList> findByEmployeeId(Integer employeeId);
}
