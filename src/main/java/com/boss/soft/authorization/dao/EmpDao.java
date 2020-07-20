package com.boss.soft.authorization.dao;

import com.boss.soft.authorization.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 86430
 * @date 2020/7/16
 */
@Repository
public interface EmpDao {
    /**
     * find all
     * @param
     * @return Result <List<Employee>>
     */
    List<Employee> empList();

    /**
     * find by id
     * @param employeeId
     * @return Result <Employee>
     */
     Employee findById(Integer employeeId);
}
