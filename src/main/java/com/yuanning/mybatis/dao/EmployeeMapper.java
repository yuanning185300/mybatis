package com.yuanning.mybatis.dao;

import java.util.List;

import com.yuanning.mybatis.bean.Employee;

public interface EmployeeMapper {
	public List<Employee> getEmpById(Employee employee);
	public void updateEmp(Employee employee);
}
