package com.boss.soft.authorization.controller;

import com.alibaba.fastjson.JSON;
import com.boss.soft.authorization.entity.Cart;
import com.boss.soft.authorization.service.EmpService;
import com.boss.soft.authorization.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 86430
 * @date 2020/7/16
 */
@RestController
public class AuthorizationController {
    @Autowired
    OrderService orderService;
    @Autowired
    EmpService empService;

    @GetMapping(value = "/cartList",produces = "application/json;charset=UTF-8")
    public String list(Map<String,Object> map){
        List<Cart> cartList = orderService.getOrder();
        map.put("cartList",cartList);
        return JSON.toJSONString(map);
    }

    @PostMapping(value = "/addForm",produces = "application/json;charset=UTF-8")
    public String addForm(@RequestBody String cartObject){
        orderService.getNewCart(cartObject);
        Map<String,Object> map = new HashMap<>(16);
        map.put("success","success");
        return JSON.toJSONString(map);
    }

    @GetMapping(value = "/findOrder",produces = "application/json;charset=UTF-8")
    public String findOrder(@RequestParam("employeeId") Integer employeeId,Map<String,Object> map){
        List<Cart> cartList = orderService.findByEmployeeId(employeeId);
        map.put("empList",cartList);
        return JSON.toJSONString(map);
    }
}
