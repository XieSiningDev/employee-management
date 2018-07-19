package com.czhou.mapper;

import com.czhou.model.Employee;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    List<Employee> selectAllEmployees();

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}