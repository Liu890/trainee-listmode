package com.example.demo.cart.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.cart.entity.OrderItems;
import com.example.demo.cart.service.impl.OrderItemsServiceImpl;
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
@RequestMapping("/orderItems")
public class OrderItemsController  {

    @Autowired
    OrderItemsServiceImpl orderItemsService;

    @PostMapping(value = "/save",produces = "application/json;charset=utf-8")
    public String save(@RequestBody OrderItems orderItems){
        boolean save = orderItemsService.save(orderItems);
        if(save == true){
            return JSON.toJSONString("success");
        }
        else{
            return JSON.toJSONString("false");
        }
    }
    @PostMapping(value = "/saveAll",produces = "application/json;charset=utf-8")
    public String save(@RequestBody List<OrderItems> orderItems){
        boolean save = orderItemsService.saveBatch(orderItems);
        if(save == true){
            return JSON.toJSONString("success");
        }
        else{
            return JSON.toJSONString("false");
        }
    }
    @GetMapping(value = "/deleteAll")
    public String deleteById(List<Integer> ids){
        boolean removeByIds = orderItemsService.removeByIds(ids);
        if(removeByIds == true){
            return JSON.toJSONString("success");
        }
        else{
            return JSON.toJSONString("false");
        }
    }

    @GetMapping(value = "/updateById",produces = "application/json;charset=utf-8")
    public String updateById(@RequestBody OrderItems orderItems) {
        boolean updateById = orderItemsService.removeById(orderItems);
        if (updateById == true) {
            return JSON.toJSONString("success");
        } else {
            return JSON.toJSONString("false");
        }
    }

    @GetMapping(value = "/updateBatch",produces = "application/json;charset=utf-8")
    public String updateBatchById(@RequestBody List<OrderItems> orderItems ) {
        boolean updateBatchById = orderItemsService.updateBatchById(orderItems);
        if (updateBatchById == true) {
            return JSON.toJSONString("success");
        } else {
            return JSON.toJSONString("false");
        }
    }

    @GetMapping(value = "/list",produces = "application/json;charset=utf-8")
    public String findAll(){
        List<OrderItems> orderItemsList = orderItemsService.list();
        return JSON.toJSONString(orderItemsList);
    }

}

