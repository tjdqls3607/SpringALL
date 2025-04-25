package com.mycom.myapp.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrdersCustomerDto {
	private int orderId;
	private String customerName;
	private String customerPhone;
	private LocalDate orderDate;
	
	public OrderCustomerDto(int orderId, String customerName, LocalDate orderDate) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.orderDate = orderDate;
	}
}
