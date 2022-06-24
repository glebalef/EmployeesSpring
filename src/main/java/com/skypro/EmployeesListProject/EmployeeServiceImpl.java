package com.skypro.EmployeesListProject;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    ArrayList<Employee> employees = new ArrayList<>(List.of(

            new Employee("Кими", "Райкконен"),
            new Employee("Майкл", "Фелпс"),
            new Employee("Альберт", "Эйнштейн"),
            new Employee("Луис", "Армстронг"),
            new Employee("Николь", "Кидман"),
            new Employee("Ева", "Грин")
    )
    );

    public final int maxEmployeesQuant = 7;

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.size() == maxEmployeesQuant) {
            throw new EmployeeStorageIsFullException();
        } else if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException();
        }
            employees.add(newEmployee);
            return newEmployee;
        }

        @Override
        public Employee removeEmployee (String firstName, String lastName) {
            Employee newEmployee = new Employee(firstName, lastName);
            if (employees.contains(newEmployee)==false) {
                throw new EmployeeNotFoundExcepation();
            } else {
                employees.remove(newEmployee);
                return newEmployee;
            }
        }

        @Override
        public Employee findEmployee (String firstName, String lastName){
               Employee newEmployee = new Employee(firstName,lastName);
               if (employees.contains(newEmployee)==true) {
                   return newEmployee;
               } else {
                   throw new EmployeeNotFoundExcepation();
               }
        }

        @Override
        public ArrayList<Employee> printAll () {
            return employees;
        }
    }


