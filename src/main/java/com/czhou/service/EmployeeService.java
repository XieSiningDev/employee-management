package com.czhou.service;

import com.czhou.model.Employee;

import java.util.List;

public interface EmployeeService {

    int deleteByPrimaryId(int id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    List<Employee> selectAllEmployees();

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}
