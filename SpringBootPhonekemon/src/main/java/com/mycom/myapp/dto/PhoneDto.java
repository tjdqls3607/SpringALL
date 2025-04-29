package com.mycom.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDto {
    private Long id;            // ID
    private String name;        // 이름
    private String manufacturer; // 제조사
    private Integer price;      // 가격
    private Integer quantity;   // 재고 수량 추가
}
