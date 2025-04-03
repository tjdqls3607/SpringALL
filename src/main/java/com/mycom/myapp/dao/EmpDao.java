package com.mycom.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.dto.EmpDto;

@Mapper
public interface EmpDao {
	List<EmpDto> listEmp();
	EmpDto detailEmp(int employeeId);
	int insertEmp (EmpDto empDto);
	int updateEmp (EmpDto empDto);
	int deleteEmp (EmpDto empDto);
}
