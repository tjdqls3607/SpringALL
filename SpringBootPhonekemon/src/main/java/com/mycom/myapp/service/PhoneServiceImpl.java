package com.mycom.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.myapp.entity.Phone;
import com.mycom.myapp.repository.PhoneRepository;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    @Override
    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone addStock(Long id, int amount) {
        Phone phone = phoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phone not found"));
        phone.setQuantity(phone.getQuantity() + amount);
        return phoneRepository.save(phone);
    }

    @Override
    public Phone sellPhone(Long id, int amount) {
        Phone phone = phoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phone not found"));
        if (phone.getQuantity() < amount) {
            throw new RuntimeException("Not enough stock");
        }
        phone.setQuantity(phone.getQuantity() - amount);
        return phoneRepository.save(phone);
    }

    @Override
    public Phone findById(Long id) {
        return phoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phone not found"));
    }
}
