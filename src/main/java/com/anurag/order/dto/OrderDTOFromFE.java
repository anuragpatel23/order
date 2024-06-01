package com.anurag.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTOFromFE {
    private Integer id;
    private List<FoodItemDTO> foodItemDTOList;
    private RestaurantDTO restaurantDTO;
    private Integer userId;
}
