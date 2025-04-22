package com.mycom.myapp.service;

import java.util.List;

import com.mycom.myapp.entity.Phone;

public interface PhoneService {
    List<Phone> findAll();
    Phone addStock(Long id, int amount);
    Phone sellPhone(Long id, int amount);
    Phone findById(Long id);
}
