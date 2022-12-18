package com.zzmr.ssm_last.service;

import com.github.pagehelper.PageInfo;
import com.zzmr.ssm_last.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     * 查询所有的员工信息
     * @return
     */
    List<Employee> getAllEmployee();

    /**
     * 获取员工的分页信息
     * @return
     */
    PageInfo<Employee> getEmployeePage(Integer pageNum);

    /**
     * 根据员工的id来查询员工信息
     * @return
     */
    Employee getEmployeeById(Integer empId);

    /**
     * 更新员工数据
     * @param employee
     */
    void updateEmployee(Employee employee);

    /**
     * 添加员工信息
     */
    void addEmployee(Employee employee);

    /**
     * 删除员工信息
     */
    void deleteEmployee(Integer empId);
}
