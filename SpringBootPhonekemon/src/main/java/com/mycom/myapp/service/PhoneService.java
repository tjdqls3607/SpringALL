package com.mycom.myapp.service;

import java.util.List;

import com.mycom.myapp.entity.Phone;

public interface PhoneService {
    List<Phone> getAllPhones();
    Phone savePhone(Phone phone);
    Phone getPhoneById(Long id);
    Phone updatePhone(Long id, Phone phone);
    boolean deletePhone(Long id);

    String getInventory();
}
