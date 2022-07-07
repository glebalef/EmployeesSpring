package com.skypro.EmployeesListProject;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Максимальная зарплата в отделе
    @Override
    public Employee findMaxEmployeeInDept(int deptNumber) {
        return employeeService.printAll().stream()
                .filter(e -> e.getDepartment() == deptNumber)
                .max(Comparator.comparing(e -> e.getSalary()))
                .get();
    }

    @Override
    public Employee findMinEmployeeInDept(int deptNumber) {
        return employeeService.printAll().stream()
                .filter(e -> e.getDepartment() == deptNumber)
                .min(Comparator.comparing(e -> e.getSalary()))
                .get();
    }
    @Override
    public List<Employee> listByDept(int deptNumber) {
        return employeeService.printAll().stream()
                .filter(e -> e.getDepartment() == deptNumber)
                .collect(Collectors.toList());
    }
    @Override
    public Map<Integer,List<Employee>> allEmployeesByDept() {
        return employeeService.printAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

    }
}
