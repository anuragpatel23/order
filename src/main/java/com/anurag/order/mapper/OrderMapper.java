package com.anurag.order.mapper;

import com.anurag.order.dto.OrderDTO;
import com.anurag.order.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderEntity mapOrderDTOToOrderRepository(OrderDTO orderDTO);
    OrderDTO mapOrderEntityToOrderDTO(OrderEntity orderEntity);

}
