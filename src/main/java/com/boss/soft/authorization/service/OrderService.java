package com.boss.soft.authorization.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boss.soft.authorization.dao.EmpDao;
import com.boss.soft.authorization.dao.ItemDao;
import com.boss.soft.authorization.dao.OrderDao;
import com.boss.soft.authorization.entity.Cart;
import com.boss.soft.authorization.entity.Employee;
import com.boss.soft.authorization.entity.Order;
import com.boss.soft.authorization.entity.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 86430
 * @date 2020/7/16
 */
@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;
    @Autowired
    ItemDao itemDao;
    @Autowired
    EmpDao empDao;

    public List<Cart> getOrder(){
        List<Order> orderList = orderDao.orderList();
        List<Cart> cartList = new ArrayList<>();
        for (int i=0;i<orderList.size();i++){
            Order order = orderList.get(i);
            Cart cart = new Cart();
            cart.setOrder(order);
            List<OrderItems> orderItemsList = itemDao.findById(order.getOrderId());
            cart.setOrderItems(orderItemsList);
            Employee employee = empDao.findById(order.getEmployeeId());
            cart.setEmployee(employee);
            cartList.add(cart);
        }
        return cartList;
    }

    public List<Cart> findByEmployeeId(Integer employeeId){
        Employee employee = empDao.findById(employeeId);
        List<Order> orderList = orderDao.findById(employeeId);
        List<Cart> cartList = new ArrayList<>();
        for (int i=0;i<orderList.size();i++){
            Cart cart = new Cart();
            cart.setEmployee(employee);
            cart.setOrder(orderList.get(i));
            Integer orderId = orderList.get(i).getOrderId();
            List<OrderItems> orderItemsList = itemDao.findById(orderId);
            cart.setOrderItems(orderItemsList);
            cartList.add(cart);
        }
        return cartList;
    }

    public void getNewCart(String cartObject){

        JSONObject jsonObject = JSON.parseObject(cartObject);
        JSONObject cartObject1 = jsonObject.getJSONObject("cart");
        JSONObject employeeObject = cartObject1.getJSONObject("employee");
        JSONObject orderObject = cartObject1.getJSONObject("order");
        JSONArray orderItems = cartObject1.getJSONArray("orderItems");

        String id = employeeObject.getString("employeeId");
        Integer employeeId = 0;
        if(id!=null){
            employeeId = Integer.parseInt(id);
        }
        Order order = new Order();
        String startDate = orderObject.getString("startDate");
        String status = orderObject.getString("status");
        order.setEmployeeId(employeeId);
        order.setStartDate(startDate);
        order.setStatus(Integer.parseInt(status));
        orderDao.addOrder(order);

        for (int i=0;i<orderItems.size();i++){
            OrderItems orderItems1 = new OrderItems();
            String dateTime = orderItems.getJSONObject(i).getString("dateTime");
            String quantity = orderItems.getJSONObject(i).getString("quantity");
            String specificationModel = orderItems.getJSONObject(i).getString("specificationModel");
            String location = orderItems.getJSONObject(i).getString("location");
            String goodsName = orderItems.getJSONObject(i).getString("goodsName");
            orderItems1.setDateTime(dateTime);
            orderItems1.setGoodsName(goodsName);
            orderItems1.setLocation(location);
            orderItems1.setOrderId(order.getOrderId());
            orderItems1.setQuantity(Integer.parseInt(quantity));
            orderItems1.setSpecificationModel(specificationModel);
            itemDao.addItems(orderItems1);
        }

    }
}
