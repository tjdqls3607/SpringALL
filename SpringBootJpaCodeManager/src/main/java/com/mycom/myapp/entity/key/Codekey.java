package com.mycom.myapp.entity.key;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

// Serializable
// 기본 생성자
@Data
@Embeddable
public class Codekey implements Serializable {

    private static final long serialVersionUID = 1L;

    private String groupCode;
    private String code;

    public Codekey(String groupCode, String code) {
        this.groupCode = groupCode;
        this.code = code;
    }

    public Codekey() {}
}
