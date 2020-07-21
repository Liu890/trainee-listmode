package com.example.demo.cart.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.cart.entity.Employee;
import com.example.demo.cart.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ljx
 * @since 2020-07-21
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController  {

    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping(value = "/save",produces = "application/json;charset=utf-8")
    public String save(@RequestBody Employee employee){
        boolean save = employeeService.save(employee);
        if(save == true){
            return JSON.toJSONString("success");
        }
        else{
            return JSON.toJSONString("false");
        }
    }

    @GetMapping(value = "/remove/{employeeId}")
    public String removeById(@PathVariable Integer employeeId){
        boolean removeById = employeeService.removeById(employeeId);
        if(removeById == true){
            return JSON.toJSONString("success");
        }
        else{
            return JSON.toJSONString("false");
        }
    }

    @GetMapping(value = "/delete")
    public String deleteById(List<Integer> ids){
        boolean removeByIds = employeeService.removeByIds(ids);
        if(removeByIds == true){
            return JSON.toJSONString("success");
        }
        else{
            return JSON.toJSONString("false");
        }
    }
    @GetMapping(value = "/updateById",produces = "application/json;charset=utf-8")
    public String updateById(@RequestBody Employee employee) {
        boolean updateById = employeeService.removeById(employee);
        if (updateById == true) {
            return JSON.toJSONString("success");
        } else {
            return JSON.toJSONString("false");
        }
    }

    @GetMapping(value = "/updateBatch",produces = "application/json;charset=utf-8")
    public String updateBatchById(@RequestBody List<Employee> employeeList) {
        boolean updateBatchById = employeeService.updateBatchById(employeeList);
        if (updateBatchById == true) {
            return JSON.toJSONString("success");
        } else {
            return JSON.toJSONString("false");
        }
    }

    @GetMapping(value = "/list",produces = "application/json;charset=utf-8")
    public String findAll(){
        List<Employee> employeeList = employeeService.list();
        return JSON.toJSONString(employeeList);
    }

    @GetMapping(value = "/find/{id}",produces = "application/json;charset=utf-8")
    public String findById(@PathVariable Integer id, HttpServletRequest request){
        Employee employee = employeeService.getById(id);
        if(employee!=null){
            return JSON.toJSONString(employee);
        }else{
            request.setAttribute("error",true);
            return JSON.toJSONString("id错误");
        }
    }

}

