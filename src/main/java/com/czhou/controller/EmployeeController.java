package com.czhou.controller;

import com.battcn.swagger.properties.ApiDataType;
import com.battcn.swagger.properties.ApiParamType;
import com.czhou.model.Employee;
import com.czhou.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
@Api(tags = "1.1", description = "员工管理", value = "员工管理")
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @ApiOperation(value = "获取所有员工")
    public List<Employee> selectAllEmployees() {
        LOGGER.info("SelectAllEmployees");
        return employeeService.selectAllEmployees();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "主键查询")
    @ApiImplicitParam(name = "id", value = "ID", dataType = ApiDataType.INT, paramType = ApiParamType.PATH)
    public Employee queryByPrimaryId(@PathVariable("id") int id) {
        LOGGER.info("QueryByPrimaryId: id = " + id);
        return employeeService.selectByPrimaryKey(id);
    }


    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "主键删除")
    @ApiImplicitParam(name = "id", value = "ID", dataType = ApiDataType.INT, paramType = ApiParamType.PATH)
    public int deleteByPrimaryId(@PathVariable("id") int id) {
        LOGGER.info("DeleteByPrimaryId: id = " + id);
        return employeeService.deleteByPrimaryId(id);
    }

    @PostMapping
    @ApiOperation(value = "新增员工")
    public int addEmployee(@RequestBody Employee employee) {
        LOGGER.info("AddEmployee: " + employee.getName());
        return employeeService.insertSelective(employee);
    }

    @PutMapping
    @ApiOperation(value = "修改员工")
    public int updateEmployee(@RequestBody Employee employee) {
        LOGGER.info("UpdateEmployee: " + employee.getId());
        return employeeService.updateByPrimaryKeySelective(employee);
    }
}
