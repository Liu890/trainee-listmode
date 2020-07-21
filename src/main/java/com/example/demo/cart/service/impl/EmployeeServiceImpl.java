package com.example.demo.cart.service.impl;

import com.example.demo.cart.entity.Employee;
import com.example.demo.cart.mapper.EmployeeMapper;
import com.example.demo.cart.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljx
 * @since 2020-07-21
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
