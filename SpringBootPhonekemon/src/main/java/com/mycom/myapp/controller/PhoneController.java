package com.mycom.myapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapp.entity.Phone;
import com.mycom.myapp.service.PhoneService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/phones")
@RequiredArgsConstructor
public class PhoneController {
    private final PhoneService phoneService;

    @GetMapping
    public List<Phone> getAllPhones() { return phoneService.findAll(); }

    @PostMapping("/{id}/sell")
    public Phone sell(@PathVariable("id") Long id, @RequestParam("quantity") int quantity) {
        return phoneService.sellPhone(id, quantity);
    }

    @PostMapping("/{id}/add")
    public Phone stock(@PathVariable("id") Long id, @RequestParam("quantity") int quantity) {
        return phoneService.addStock(id, quantity);
    }


    @GetMapping("/{id}")
    public Phone getPhone(@PathVariable Long id) {
        return phoneService.findById(id);
    }
}

