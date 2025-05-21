package com.mycom.myapp.dto;

import com.mycom.myapp.entity.Code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CodeDto {

    private String groupCode;
    private String code;
    private String codeName;
    private String codeNameBrief;
    private int orderNo;

    public static CodeDto fromCode(Code code) {
        return CodeDto.builder()
                .groupCode(code.getCodekey().getGroupCode())
                .code(code.getCodekey().getCode())
                .codeName(code.getCodeName())
                .codeNameBrief(code.getCodeNameBrief())
                .orderNo(code.getOrderNo())
                .build();
    }
}
