package com.mycom.myapp.phone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.myapp.phone.dao.PhoneDao;
import com.mycom.myapp.phone.dto.PhoneDto;

@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneDao phoneDao;

    public PhoneServiceImpl(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }

    @Override
    public List<PhoneDto> phoneList() {
        return phoneDao.phoneList();
    }

    @Override
    public PhoneDto phoneDetail(int phoneId) {
        return phoneDao.phoneDetail(phoneId);
    }

    @Override
    public int phoneInsert(PhoneDto dto) {
        return phoneDao.phoneInsert(dto);
    }

    @Override
    public int phoneUpdate(PhoneDto dto) {
        return phoneDao.phoneUpdate(dto);
    }

    @Override
    public int phoneDelete(int phoneId) {
        return phoneDao.phoneDelete(phoneId);
    }
}
