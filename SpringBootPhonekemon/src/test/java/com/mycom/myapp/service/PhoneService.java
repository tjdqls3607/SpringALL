package com.mycom.myapp.service;

import org.springframework.stereotype.Service;

@Service
public class PhoneService {

    public String getInventory() {
        // 간단한 재고 정보 예시
        return """
        {
            "iPhone 13": 50,
            "Samsung Galaxy S21": 30,
            "Google Pixel 6": 20
        }
        """;
    }
}
