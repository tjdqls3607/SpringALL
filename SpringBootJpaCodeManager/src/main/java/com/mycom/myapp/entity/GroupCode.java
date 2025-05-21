package com.mycom.myapp.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


// @Id 컬럼에 @GenerationValue 사용 X
@Entity
@Data
@Table(name="group_code")
public class GroupCode {

    @Id
    @Column (name="group_code")
    private String groupCode;

    @Column (name="group_Code_Name")
    private String groupCodeName;

    @Column (name = "group_Code_Desc")
    private String groupCodeDesc;
}
