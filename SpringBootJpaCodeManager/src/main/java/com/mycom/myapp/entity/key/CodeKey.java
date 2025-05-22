package com.mycom.myapp.entity.key;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

// 멀티키에 대응하기 위한 것. 복합키를 구성하는 컬럼들을 정의
// Serializable 인터페이스
// 기본생성자
@Data
@Embeddable
public class CodeKey implements Serializable {
    private static final long serialVersionUID = 1L;

    private String groupCode;
    private String code;

    public CodeKey() {}
    public CodeKey(String groupCode, String code) {
        this.groupCode = groupCode;
        this.code = code;
    }
}