package com.mycom.myapp.auth.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.user.dto.UserDto;

//사용자가 입력한 이메일, 비밀번호 중 이메일로 select 해서 있으면 나머지 데이터를 포함해서 USERDTO 객체를 없으면 널을 리턴
// 서비스단에서 사용자가 입력한 이메일,비번 일치 여부 확인
@Mapper
public interface LoginDao {
	UserDto login(String userEmail);
}
