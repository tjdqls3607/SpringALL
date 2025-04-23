package com.mycom.myapp.phone.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.phone.dto.PhoneDto;

@Mapper
public interface PhoneDao {
    List<PhoneDto> phoneList();
    PhoneDto phoneDetail(int phoneId);
    int phoneInsert(PhoneDto dto);
    int phoneUpdate(PhoneDto dto);
    int phoneDelete(int phoneId);
}
