package com.mycom.myapp.service;

import java.util.List;

import com.mycom.myapp.dto.OrdersDto;
import com.mycom.myapp.entity.Orders;

public interface OrdersService {
	
	// #0, #1
	List<Orders> listOrder();
	
	// #2
	List<OrdersDto> listOrdersSeviceDto();
	
	// #3
	List<OrdersDto> listOrdersRepositoryDto();
}
