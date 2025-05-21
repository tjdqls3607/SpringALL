package com.mycom.myapp.entity;


import com.mycom.myapp.entity.key.Codekey;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@Embeddable
public class Code {

    Codekey codekey;

    @Column (name = "code_name")
    private String codeName;

    @Column (name = "code_name_brief")
    private String codeNameBrief; // 약어

    @Column (name = "order_no")
    private int orderNo;
}
