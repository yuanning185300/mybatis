package com.yuanning.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanning.mybatis.bean.Employee;

public interface EmployeeMapper {
	public List<Employee> getEmpById(Employee employee);
	public void updateEmp(Employee employee);
	public List<Employee> getEmpByIds(List<Integer> ids);
	public void addEmps(@Param("employees")List<Employee> employees);

}
