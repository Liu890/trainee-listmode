package com.example.demo.cart.mapper;

import com.example.demo.cart.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.cart.entity.OrderList;
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
@SuppressWarnings("ALL")
@Component
public interface EmployeeMapper extends BaseMapper<Employee> {

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

