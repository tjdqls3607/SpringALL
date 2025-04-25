package com.mycom.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mycom.myapp.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	
	@Query("select 0 from Orders o")
	List<Orders> listOrder();

}
