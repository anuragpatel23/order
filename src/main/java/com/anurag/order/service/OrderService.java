package com.anurag.order.service;

import com.anurag.order.dto.OrderDTO;
import com.anurag.order.dto.OrderDTOFromFE;
import com.anurag.order.dto.UserDTO;
import com.anurag.order.entity.OrderEntity;
import com.anurag.order.mapper.OrderMapper;
import com.anurag.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    public OrderDTO saveOrderInDb(OrderDTOFromFE orderDetails) {
        Integer newOrderId = sequenceGenerator.generateNextOrderId();
        UserDTO user = fetchUserDetailsFromUserId(orderDetails.getUserId());
        OrderEntity orderToBeSaved = new OrderEntity(newOrderId, orderDetails.getFoodItemDTOList(),
                orderDetails.getRestaurantDTO(), user);
        orderRepository.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderEntityToOrderDTO(orderToBeSaved);
    }

    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://USER-SERVICE/user/fetchUser/"+userId, UserDTO.class);
    }
}
