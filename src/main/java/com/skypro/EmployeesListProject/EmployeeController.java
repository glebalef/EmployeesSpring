package com.skypro.EmployeesListProject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam(value = "firstName") String firstName,
                                @RequestParam(value = "lastName") String lastName,
                                @RequestParam(value = "salary") double salary,
                                @RequestParam(value = "department") int department) {
        if (StringUtils.isAlpha(firstName)&&StringUtils.isAlpha(lastName)) {
        } else throw new EmployeeWrongNameExeption();
        return employeeService.addEmployee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), salary, department);
    }


    @GetMapping(path = "/print")
    public Collection<Employee> printAll() {
        return employeeService.printAll();
    }

    @GetMapping(path = "/remove")
    public void removeEmployee(@RequestParam(value = "firstName") String firstName,
                                   @RequestParam(value = "lastName") String lastName) {

}

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam(value = "firstName") String firstName,
                                 @RequestParam(value = "lastName") String lastName) {
        return employeeService.findEmployee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName));
    }
}

