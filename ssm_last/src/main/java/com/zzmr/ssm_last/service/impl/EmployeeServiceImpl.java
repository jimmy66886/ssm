package com.zzmr.ssm_last.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzmr.ssm_last.mapper.EmployeeMapper;
import com.zzmr.ssm_last.pojo.Employee;
import com.zzmr.ssm_last.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        //先开启分页功能
        PageHelper.startPage(pageNum, 4);
        //查询所有员工信息
        List<Employee> list = employeeMapper.getAllEmployee();
        //    获取分页相关数据
        PageInfo<Employee> page = new PageInfo<>(list, 5);
        return page;
    }


    @Override
    public Employee getEmployeeById(Integer empId) {
        return employeeMapper.getEmployeeById(empId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
        System.out.println("修改成功-service");
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer empId) {
        employeeMapper.deleteEmployee(empId);
    }
}
