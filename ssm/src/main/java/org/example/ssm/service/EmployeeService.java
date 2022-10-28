package org.example.ssm.service;

import com.github.pagehelper.PageInfo;
import org.example.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    PageInfo<Employee> getEmployeePage(Integer pagenum);
}
