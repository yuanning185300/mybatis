package com.yuanning.mybatis.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.yuanning.mybatis.bean.Employee;
import com.yuanning.mybatis.dao.EmployeeMapper;

public class MybatisTest {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "conf/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
	
	@Test
	public void test01() throws IOException{
		SqlSessionFactory sqlSessionFactory =getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
		Employee employee=new Employee(null, "%a%", null, null);
		List<Employee> selectOne = mapper.getEmpById(employee);
		
		System.out.println(selectOne);
		openSession.close();
	}
	
	@Test
	public void test02() throws IOException{
		SqlSessionFactory sqlSessionFactory =getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
		Employee employee=new Employee(2, null, null, "1");

		mapper.updateEmp(employee);
		openSession.commit();
		openSession.close();
	}

}
