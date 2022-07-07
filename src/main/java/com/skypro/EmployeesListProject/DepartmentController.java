package com.skypro.EmployeesListProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping(path = "/max-salary")
    public Employee findMaxEmployee(@RequestParam(value = "DeptNumber") Integer number) {
        return departmentService.findMaxEmployeeInDept(number);
    }

    @GetMapping(path = "/all")
    public List<Employee> printByDept(@RequestParam(value = "DeptNumber") Integer number) {
        return departmentService.listByDept(number);
    }

    @GetMapping(path="/all")
    public Map<Integer,List<Employee>> allEmployeesByDept() {
        return departmentService.allEmployeesByDept();
    }
}
