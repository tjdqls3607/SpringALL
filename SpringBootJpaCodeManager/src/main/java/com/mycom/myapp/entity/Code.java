package com.mycom.myapp.entity;

import com.mycom.myapp.entity.key.CodeKey;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

// 복합키: CodeKey
@Entity
@Data
public class Code {

    // 복합키
    @EmbeddedId
    CodeKey codeKey;

    @Column(name="code_name")
    private String codeName;

    @Column(name="code_name_brief")
    private String codeNameBrief; // 약어

    @Column(name="order_no")
    private int orderNo;
}