package org.example.ssm.controller;


import com.github.pagehelper.PageInfo;
import org.example.ssm.pojo.Employee;
import org.example.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 查询所有的员工信息-->/employee -- >get
 * 根据id查询员.工信息-->/employee/1-->get
 * 跳转到添加页面-->/to/add-->get
 * 添加员工信息- ->/employee-->post
 * 修改员工信息-->/employee-->put
 * 删除员工信息-->/employee/1-->delete
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employee/page/{pagenum}")
    public String getEmployeePage(@PathVariable("pagenum") Integer pagenum,Model model){
        System.out.println("更新1");
        //获取员工的分页信息
        PageInfo<Employee> page = employeeService.getEmployeePage(pagenum);
        //将分页数据共享到请求域中
        model.addAttribute("page",page);
        return "employee_list";
    }



    @GetMapping("/employee")
    public String getAllEmployee(Model model){
        List<Employee> lists = employeeService.getAllEmployee();
//        System.out.println(lists.size());
        model.addAttribute("employeelist",lists);
        return "employee_list";
    }
}
