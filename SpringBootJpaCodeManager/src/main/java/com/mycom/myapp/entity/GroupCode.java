package com.mycom.myapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;

// Id 컬럼에 @GeneratedValue 사용 X.
// => JPA의 key 중심 능동적인 제어에 영향을 미친다.
// 현재 insert시 select 2건 수행 후 insert 1건 수행됨.
// insert 시점에 key 값이 존재하더라도 (원래는 save()가 update처리되어야 하는데 그게 안됨)
// insert 시점에 우선 entityManager의 관리 대상인지 확인 <- 첫번째 select
// insert 시점에 Transient 체크하는 내부 로직이 있음. <- 두번째 select
// (insert도 bulk로 진행할 것이기 때문에) 공통코드 자체에는 문제가 없지만,
// @GeneratedValue 사용 X인 다른 상황에서 어떻게 처리해야 하는가? 추가적인 조치 취해야 함.
@Entity
@Data
@Table(name="group_code")
public class GroupCode implements Persistable<String> {
    @Id
    @Column(name="group_code")
    private String groupCode;

    @Column(name="group_code_name")
    private String groupCodeName;

    @Column(name="group_code_desc")
    private String groupCodeDesc;

    @Transient // entity와 연결되면 안되기 때문에 Transient 붙여줌.
    private boolean isNew = false;

    @Override
    public String getId() {
        return groupCode;
    }
}