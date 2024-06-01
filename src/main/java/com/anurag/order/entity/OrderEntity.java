package com.anurag.order.entity;

import com.anurag.order.dto.FoodItemDTO;
import com.anurag.order.dto.RestaurantDTO;
import com.anurag.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class OrderEntity{
    private Integer orderId;
    private List<FoodItemDTO> foodItemDTOList;
    private RestaurantDTO restaurantDTO;
    private UserDTO userDTO;
}
