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

    // ❗ 여기 수정됨: null 값 덮어쓰기 방지
    @Override
    public Phone updatePhone(Long id, Phone updatedPhone) {
        return phoneRepository.findById(id)
                .map(phone -> {
                    if (updatedPhone.getName() != null) {
                        phone.setName(updatedPhone.getName());
                    }
                    if (updatedPhone.getManufacturer() != null) {
                        phone.setManufacturer(updatedPhone.getManufacturer());
                    }
                    if (updatedPhone.getPrice() != null) {
                        phone.setPrice(updatedPhone.getPrice());
                    }
                    // 수량은 null 체크 (0은 유효한 값이니 null만 걸러야 함)
                    if (updatedPhone.getQuantity() != null) {
                        phone.setQuantity(updatedPhone.getQuantity());
                    }
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


    public String getInventory() {
        // 예시로 재고 정보를 JSON 형태로 반환
        return """
                {
                    "iPhone 13": 50,
                    "Samsung Galaxy S21": 30,
                    "Google Pixel 6": 20
                }
                """;
    }
}
