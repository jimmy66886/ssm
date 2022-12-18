package com.zzmr.ssm_last.mapper;

import com.zzmr.ssm_last.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    /**
     * 查询所有的员工信息
     * @return
     */
    List<Employee> getAllEmployee();

    /**
     * 根据员工的id来查询员工信息
     * @return
     */
    Employee getEmployeeById(Integer empId);

    /**
     * 修改员工信息
     * @param employee
     */
    void updateEmployee(Employee employee);

    /**
     * 添加员工信息
     * @param employee
     */
    void addEmployee(Employee employee);

    /**
     * 删除员工信息
     * @param empId
     */
    void deleteEmployee(Integer empId);
}
