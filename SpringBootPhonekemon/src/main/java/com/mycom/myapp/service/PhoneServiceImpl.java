package com.mycom.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.entity.Phone;
import com.mycom.myapp.repository.PhoneRepository;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone getPhoneById(Long id) {
        return phoneRepository.findById(id).orElse(null);
    }

    @Override
    public Phone savePhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public Phone updatePhone(Long id, Phone updatedPhone) {
        return phoneRepository.findById(id)
            .map(phone -> {
                // 기존 phone 정보를 updatedPhone에서 받아온 값으로 갱신
                phone.update(updatedPhone.getName(), updatedPhone.getManufacturer(), updatedPhone.getPrice(), updatedPhone.getQuantity());
                return phoneRepository.save(phone);
            })
            .orElse(null);
    }

    @Override
    public boolean deletePhone(Long id) {
        if (phoneRepository.existsById(id)) {
            phoneRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
