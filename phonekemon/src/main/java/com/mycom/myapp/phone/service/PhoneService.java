package com.mycom.myapp.phone.service;

import java.util.List;
import com.mycom.myapp.phone.dto.PhoneDto;

public interface PhoneService {
    List<PhoneDto> phoneList();
    PhoneDto phoneDetail(int phoneId);
    int phoneInsert(PhoneDto dto);
    int phoneUpdate(PhoneDto dto);
    int phoneDelete(int phoneId);
}
