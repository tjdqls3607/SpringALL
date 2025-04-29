package com.mycom.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneResultDto {
    private String result;          // 결과 상태 (success, error 등)
    private PhoneDto phoneDto;      // 특정 폰의 상세 정보
    private List<PhoneDto> phoneList; // 폰 목록
    private Long count;             // 폰 목록의 개수
}
