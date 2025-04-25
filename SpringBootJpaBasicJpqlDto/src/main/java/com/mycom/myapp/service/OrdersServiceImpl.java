package com.mycom.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
}
