
package com.mycom.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mycom.myapp.entity.Phone;
import com.mycom.myapp.service.PhoneService;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping
    public ResponseEntity<List<Phone>> getAllPhones() {
        List<Phone> phones = phoneService.getAllPhones();
        return ResponseEntity.ok(phones);
    }

    @PostMapping
    public ResponseEntity<Phone> addPhone(@RequestBody Phone phone) {
        Phone savedPhone = phoneService.savePhone(phone);
        return ResponseEntity.ok(savedPhone);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Phone> getPhoneById(@PathVariable Long id) {
        Phone phone = phoneService.getPhoneById(id);
        if (phone != null) {
            return ResponseEntity.ok(phone);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Phone> updatePhone(@PathVariable Long id, @RequestBody Phone updatedPhone) {
        Phone phone = phoneService.updatePhone(id, updatedPhone);
        if (phone != null) {
            return ResponseEntity.ok(phone);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhone(@PathVariable Long id) {
        boolean deleted = phoneService.deletePhone(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 재고 업데이트 API (POST로 변경)
    @PostMapping("/{id}/{action}")
    public ResponseEntity<String> updateStock(@PathVariable Long id, @PathVariable String action, @RequestBody StockUpdateRequest stockUpdateRequest) {
        Phone phone = phoneService.getPhoneById(id);
        if (phone == null) {
            return ResponseEntity.notFound().build();
        }

        int quantity = stockUpdateRequest.getQuantity();
        if (action.equals("add")) {
            phone.setQuantity(phone.getQuantity() + quantity);
        } else if (action.equals("sell")) {
            if (phone.getQuantity() < quantity) {
                return ResponseEntity.badRequest().body("판매할 수 있는 수량이 부족합니다.");
            }
            phone.setQuantity(phone.getQuantity() - quantity);
        } else {
            return ResponseEntity.badRequest().body("잘못된 작업 타입입니다.");
        }

        phoneService.savePhone(phone);
        return ResponseEntity.ok("재고 업데이트가 완료되었습니다.");
    }

    public static class StockUpdateRequest {
        private int quantity;

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    // logging aspect
    @GetMapping("/inventory")
    public ResponseEntity<String> getInventory() {
        // 재고 정보를 가져옴 (예시: JSON 반환)
        String inventory = phoneService.getInventory();
        return ResponseEntity.ok(inventory);
    }
}

