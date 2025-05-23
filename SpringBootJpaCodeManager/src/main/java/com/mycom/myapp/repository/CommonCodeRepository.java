package com.mycom.myapp.repository;

import com.mycom.myapp.entity.Code;
import com.mycom.myapp.entity.key.CodeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CommonCodeRepository extends JpaRepository<Code, CodeKey> {
    @Query("select c from Code c where c.id.groupCode in :groupCodes order by c.id.groupCode, c.orderNo") // 그룹코드별 정렬
    List<Code> findByGroupCodes(@Param("groupCodes") List<String> groupCodes); // 그룹코드 여러개 넘어옴.
}