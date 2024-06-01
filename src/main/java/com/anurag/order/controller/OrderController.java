package com.anurag.order.controller;

import com.anurag.order.dto.OrderDTO;
import com.anurag.order.dto.OrderDTOFromFE;
import com.anurag.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDetails){
        OrderDTO order = orderService.saveOrderInDb(orderDetails);
        return new ResponseEntity<>(order, HttpStatus.CREATED);

    }
}
