package com.mycom.myapp.phone.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.mycom.myapp.phone.dto.PhoneDto;
import com.mycom.myapp.phone.service.PhoneService;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {

    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping
    public List<PhoneDto> phoneList() {
        return phoneService.phoneList();
    }

    @GetMapping("/{id}")
    public PhoneDto phoneDetail(@PathVariable("id") int id) {
        return phoneService.phoneDetail(id);
    }

    @PostMapping
    public int phoneInsert(@RequestBody PhoneDto dto) {
        return phoneService.phoneInsert(dto);
    }

    @PutMapping("/{id}")
    public int phoneUpdate(@PathVariable("id") int id, @RequestBody PhoneDto dto) {
        dto.setPhoneId(id);
        return phoneService.phoneUpdate(dto);
    }

    @DeleteMapping("/{id}")
    public int phoneDelete(@PathVariable("id") int id) {
        return phoneService.phoneDelete(id);
    }
}
