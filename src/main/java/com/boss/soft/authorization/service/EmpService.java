package com.boss.soft.authorization.service;

import com.boss.soft.authorization.dao.EmpDao;
import com.boss.soft.authorization.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 86430
 * @date 2020/7/15
 */
@Service
public class EmpService {

    @Autowired
    EmpDao ed;

    public List<Employee> getAll(){
        return ed.empList();
    }
}
