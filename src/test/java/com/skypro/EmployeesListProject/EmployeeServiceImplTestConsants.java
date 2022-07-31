package com.skypro.EmployeesListProject;

import java.util.*;

public class EmployeeServiceImplTestConsants {

public static final Employee testEmployee = new Employee("Jon", "Doe", 10000, 1);
public static String jon = new String ("Jon");
public static String doe = new String ("Doe");
public static double testSalary = 10000;
public static int testDeptNumber = 1;

// for DepartmentService testing

    public static Employee homelander = new Employee("Homelander", "Super", 100000, 1);
    public static Employee starlight = new Employee("Starlight", "Super", 50000, 1);
    public static Employee deep = new Employee("deep", "Super", 30000, 1);
    public static Employee stormfront = new Employee("Stormfront", "Super", 80000, 2);

    public static Collection testList = List.of(
            homelander,
            starlight,
            deep,
            stormfront
    );

    public static Collection testListDept1 = List.of(
            homelander,
            starlight,
            deep
    );
}
