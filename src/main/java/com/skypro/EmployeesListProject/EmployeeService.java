package com.skypro.EmployeesListProject;

import java.util.ArrayList;

public interface EmployeeService {

public Employee addEmployee (String firstName, String LastName);

public Employee removeEmployee (String firstName, String LastName);

public Employee findEmployee (String firstName, String LastName);

public ArrayList<Employee> printAll ();

}
