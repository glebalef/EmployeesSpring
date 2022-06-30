package com.skypro.EmployeesListProject;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<String, Employee> employees = new HashMap<>();

    public final int maxEmployeesQuant = 7;

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        String fullName = firstName+" "+lastName;
        if (employees.size() == maxEmployeesQuant) {
            throw new EmployeeStorageIsFullException();
        } else if (employees.containsKey(fullName)) {
            throw new EmployeeAlreadyAddedException();
        }
            employees.put(fullName,newEmployee);
            return newEmployee;
        }

        @Override
        public Employee removeEmployee (String firstName, String lastName) {
            String fullName = firstName+" "+lastName;
            if (!employees.containsKey(fullName)) {
                throw new EmployeeNotFoundExcepation();
            } else {
                employees.remove(fullName);
                return new Employee(firstName, lastName);
            }
        }

        @Override
        public Employee findEmployee (String firstName, String lastName) {
               String fullName = firstName+" "+lastName;
               if (employees.containsKey(fullName)) {
                   return employees.get(fullName);
               } else {
                   throw new EmployeeNotFoundExcepation();
               }
        }

        @Override
        public Collection<Employee> printAll () {
            return employees.values();
        }
    }


