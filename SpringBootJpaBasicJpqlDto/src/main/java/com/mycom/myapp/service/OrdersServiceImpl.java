package com.mycom.myapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.myapp.dto.OrdersDto;
import com.mycom.myapp.entity.Orders;
import com.mycom.myapp.repository.OrdersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {

	private final OrdersRepository ordersRepository;

	@Override
	public List<Orders> listOrder() {
		return ordersRepository.listOrder();
	}

	@Override
	public List<OrdersDto> listOrdersSeviceDto() {
		List<Orders> ordersList = ordersRepository.listOrder();
		List<OrdersDto> ordersDtoList = new ArrayList<>();
		
		ordersList.forEach(orders -> {
			OrdersDto ordersDto = 
					OrdersDto.builder()
					.id(orders.getId())
					.orderQuantity(orders.getOrderQuantity())
					.orderDate(orders.getOrderDate())
					.build();
			ordersDtoList.add(ordersDto);
		});
		
		return ordersDtoList;
	}

	@Override
	public List<OrdersDto> listOrdersRepositoryDto() {
		
		return ordersRepository.listOrdersRepositoryDto();
	} 
}
