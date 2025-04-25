package com.mycom.myapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapp.entity.Orders;
import com.mycom.myapp.service.OrdersService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrdersController {
	
	private final OrdersService ordersService;
	
	// #0
	// Controller 에서 Entity 를 JSON 변환, 응답
	@GetMapping("listOrders")
	public List<Orders> listOrders() {
		return ordersService.listOrder();
	}
}
