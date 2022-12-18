package com.zzmr.ssm_last.controller;

import com.github.pagehelper.PageInfo;
import com.zzmr.ssm_last.pojo.Employee;
import com.zzmr.ssm_last.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/*
    查询所有的员工信息-->/employee--->get
    查询员工的分页信息-->/employee/page/1--->get
    根据id查询员工信息-->/employee/1--->get
    跳转到添加页面-->to/add--->get
    添加员工信息-->/employee--->post
    跳转到修改页面-->/employee/1--->get
    修改员工信息-->/employee--->put
    删除员工信息-->/employee/1--->delete
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model) {
        //查询所有的员工信息
        List<Employee> list = employeeService.getAllEmployee();
        model.addAttribute("list", list);
        //跳转到employee_list.html页面
        return "employee_list";
    }

    @RequestMapping(value = "/employee/page/{pageNum}", method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum, Model model) {
        //获取分页相关的数据
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        //    将分页数据共享到请求域中
        model.addAttribute("page", page);
        //    跳转到列表页面
        return "employee_page";
    }

    //    先写一个方法，跳转到修改页面
    @RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET)
    public String toUpdateEmployee(@PathVariable("empId") Integer empId,Model model) {
        //    根据员工id查到员工信息
        Employee employee = employeeService.getEmployeeById(empId);
        System.out.println("跳转页面的"+employee);
        //    将员工信息共享到请求域中,作用就是让修改的时候能看到原来的信息是什么
        model.addAttribute("employee",employee);
        return "employee_update";
    }


    /**
     * 跳转的时候id还在，跳到修改页面，id就为null了，所以没有修改成功，问题找到了
     */

//    修改员工的方法
    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        employeeService.updateEmployee(employee);
        System.out.println(employee);
        return "redirect:/employee/page/1";
    }

    /**
     * 跳转到添加页面的方法并不需要，可以直接在springMVC配置文件中添加
     *     <mvc:view-controller path="/to/add" view-name="employee_add"></mvc:view-controller>
     *    就可以了
     */

    //那就写添加员工信息的控制器方法
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/employee/page/1";
    }

    /**
     * 删除员工的控制器方法
     */
    @RequestMapping(value = "/employee/{empId}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("empId") Integer empId){
        employeeService.deleteEmployee(empId);
        return "redirect:/employee/page/1";
    }

}
