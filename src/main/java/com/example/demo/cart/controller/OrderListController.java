package com.example.demo.cart.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.cart.entity.OrderList;
import com.example.demo.cart.service.impl.OrderListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping("/orderList")
public class OrderListController {

    @Autowired
    OrderListServiceImpl orderListService;

    @PostMapping(value = "/save",produces = "application/json;charset=utf-8")
    public String save(@RequestBody OrderList order){
        boolean save = orderListService.save(order);
        if(save == true){
            return JSON.toJSONString("success");
        }
        else{
            return JSON.toJSONString("false");
        }
    }
    @GetMapping(value = "/delete/{orderId}")
    public String removeById(@PathVariable Integer orderId){
        boolean removeById = orderListService.removeById(orderId);
        if(removeById == true){
            return JSON.toJSONString("success");
        }
        else{
            return JSON.toJSONString("false");
        }
    }

    @GetMapping(value = "/updateById",produces = "application/json;charset=utf-8")
    public String updateById(@RequestBody OrderList order) {
        boolean updateById = orderListService.updateById(order);
        if (updateById == true) {
            return JSON.toJSONString("success");
        } else {
            return JSON.toJSONString("false");
        }
    }

    @GetMapping(value = "/updateBatch",produces = "application/json;charset=utf-8")
    public String updateBatchById(@RequestBody List<OrderList> OrderList) {
        boolean updateBatchById = orderListService.updateBatchById(OrderList);
        if (updateBatchById == true) {
            return JSON.toJSONString("success");
        } else {
            return JSON.toJSONString("false");
        }
    }

    @GetMapping(value = "/list",produces = "application/json;charset=utf-8")
    public String findAll(){
        List<OrderList> orderLists = orderListService.list();
        return JSON.toJSONString(orderLists);
    }

}

