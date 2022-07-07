package com.skypro.EmployeesListProject;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    ArrayList<Employee> employees = new ArrayList<>();
    public final int maxEmployeesQuant = 7;

    @Override
    public Employee addEmployee(String firstName, String lastName, double salary, int department) {
        Employee newEmployee = new Employee(firstName, lastName, salary, department);
        if (employees.size() == maxEmployeesQuant) {
            throw new EmployeeStorageIsFullException();
        } else if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(newEmployee);
        return newEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName, 0, 0);
        if (employees.contains(newEmployee) == false) {
            throw new EmployeeNotFoundExcepation();
        } else {
            employees.remove(newEmployee);
            return newEmployee;
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName, 0, 0);
        if (employees.contains(newEmployee) == true) {
            return newEmployee;
        } else {
            throw new EmployeeNotFoundExcepation();
        }
    }

    @Override
    public ArrayList<Employee> printAll() {
        return employees;
    }



}



