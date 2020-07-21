package com.example.demo.cart.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.cart.entity.OrderItems;
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
public interface OrderItemsMapper extends BaseMapper<OrderItems> {

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
