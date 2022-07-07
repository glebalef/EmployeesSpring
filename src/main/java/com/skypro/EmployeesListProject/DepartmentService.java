package com.skypro.EmployeesListProject;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    public Employee findMaxEmployeeInDept(int deptNumber);
    public Employee findMinEmployeeInDept(int deptNumber);
    public List<Employee> listByDept(int deptNumber);

    public Map<Integer,List<Employee>> allEmployeesByDept();
}
