package com.example.demo.cart.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.entity.Employee;
import com.example.demo.cart.entity.OrderItems;
import com.example.demo.cart.entity.OrderList;
import com.example.demo.cart.service.impl.EmployeeServiceImpl;
import com.example.demo.cart.service.impl.OrderItemsServiceImpl;
import com.example.demo.cart.service.impl.OrderListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 86430
 * @date 2020/7/21
 */
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    OrderItemsServiceImpl orderItemsService;
    @Autowired
    OrderListServiceImpl orderListService;

    @PostMapping(value = "/save",produces = "application/json;charset=utf-8")
    public String save(@RequestBody Cart cart){
        boolean eSave = employeeService.save(cart.getEmployee());
        boolean oSave = orderListService.saveBatch(cart.getOrderList());
        boolean iSave = orderItemsService.saveBatch(cart.getOrderItems());
        if(eSave == true && oSave == true && iSave == true){
            return JSON.toJSONString("success");
        }else {
            return JSON.toJSONString("false");
        }
    }
    @GetMapping(value = "/delete")
    public String deleteById(List<Integer> ids){
        boolean removeOrder = orderListService.removeByIds(ids);
        boolean removeItems = orderItemsService.removeByIds(ids);
        if(removeOrder == true && removeItems == removeItems){
            return JSON.toJSONString("success");
        }
        else{
            return JSON.toJSONString("false");
        }
    }
    @GetMapping(value = "/updateById",produces = "application/json;charset=utf-8")
    public String updateById(@RequestBody Cart cart) {
        Employee employee = cart.getEmployee();
        List<OrderList> orderList = cart.getOrderList();
        List<OrderItems> orderItemsList = cart.getOrderItems();
        boolean updateEmployee = employeeService.updateById(employee);
        boolean updateOrder = orderListService.updateBatchById(orderList);
        boolean updateItems = orderItemsService.updateBatchById(orderItemsList);
        if (updateEmployee == true && updateItems == true && updateOrder == true) {
            return JSON.toJSONString("success");
        } else {
            return JSON.toJSONString("false");
        }
    }

    @PostMapping(value = "/list",produces = "application/json;charset=utf-8")
    public String list(@RequestParam Integer employeeId){
        Cart cart = new Cart();
        List<Integer> orderIdList = new ArrayList<>();
        Employee employee = employeeService.getById(employeeId);
        cart.setEmployee(employee);
        List<OrderList> orderLists = orderListService.findByEmployeeId(employeeId);
        cart.setOrderList(orderLists);
        for (int i=0;i<orderLists.size();i++){
            orderIdList.add(orderLists.get(i).getOrderId());
        }
        List<OrderItems> orderItems =(List<OrderItems>) orderItemsService.listByIds(orderIdList);
        cart.setOrderItems(orderItems);
        return JSON.toJSONString(cart);
    }
}
