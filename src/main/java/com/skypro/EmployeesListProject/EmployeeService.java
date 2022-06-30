package com.skypro.EmployeesListProject;

import java.util.ArrayList;
import java.util.Collection;

public interface EmployeeService {

public Employee addEmployee (String firstName, String LastName);

public Employee removeEmployee (String firstName, String LastName);

public Employee findEmployee (String firstName, String LastName);

public Collection<Employee> printAll ();

}
