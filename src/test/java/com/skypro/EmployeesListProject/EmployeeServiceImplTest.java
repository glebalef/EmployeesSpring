package com.skypro.EmployeesListProject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.invoke.WrongMethodTypeException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class EmployeeServiceImplTest {

    private final EmployeeServiceImpl out = new EmployeeServiceImpl();
    Map<String, Employee> employees = new HashMap<>();

    @Test
    public void shouldAddJonDoe() {
        Map<String, Employee> testList = new HashMap<String, Employee>();
        testList.put("Jon Doe", EmployeeServiceImplTestConsants.testEmployee);
        Employee result = out.addEmployee(EmployeeServiceImplTestConsants.jon, EmployeeServiceImplTestConsants.doe, EmployeeServiceImplTestConsants.testSalary, EmployeeServiceImplTestConsants.testDeptNumber);
        Assertions.assertTrue(result.equals(EmployeeServiceImplTestConsants.testEmployee));
        Assertions.assertEquals(EmployeeServiceImplTestConsants.testEmployee, result);
    }

    @Test
    public void shouldFindJonDoe() {
        Map<String, Employee> employees = new HashMap<String, Employee>();
        out.addEmployee("Homelander", "Super", 10000, 1);
        out.addEmployee("Starlight", "Super", 10000, 1);
        out.addEmployee("TrainA", "Super", 10000, 1);
        out.addEmployee("Stormfront", "Super", 10000, 1);
        out.addEmployee("Deep", "Super", 10000, 1);
        out.addEmployee("Translucent", "Super", 10000, 1);
        out.addEmployee(EmployeeServiceImplTestConsants.jon, EmployeeServiceImplTestConsants.doe, 10000, 1);
        Employee result = out.findEmployee(EmployeeServiceImplTestConsants.jon, EmployeeServiceImplTestConsants.doe);
        Assertions.assertTrue(result.equals(EmployeeServiceImplTestConsants.testEmployee));
        Assertions.assertEquals(EmployeeServiceImplTestConsants.testEmployee, result);
    }

    @Test
    public void shouldThrowWrongNameExeption() {
        Assertions.assertThrows(EmployeeWrongNameExeption.class,
                () -> out.addEmployee("123", EmployeeServiceImplTestConsants.doe, EmployeeServiceImplTestConsants.testSalary, EmployeeServiceImplTestConsants.testDeptNumber)
        );
        Assertions.assertThrows(EmployeeWrongNameExeption.class,
                () -> out.addEmployee(EmployeeServiceImplTestConsants.jon, "123", EmployeeServiceImplTestConsants.testSalary, EmployeeServiceImplTestConsants.testDeptNumber)
        );
    }

    @Test
    public void shouldThrowEmployeeStorageFullException() {
        Map<String, Employee> employees = new HashMap<String, Employee>();
        out.addEmployee("Homelander", "Super", 10000, 1);
        out.addEmployee("Starlight", "Super", 10000, 1);
        out.addEmployee("TrainA", "Super", 10000, 1);
        out.addEmployee("Stormfront", "Super", 10000, 1);
        out.addEmployee("Deep", "Super", 10000, 1);
        out.addEmployee("Translucent", "Super", 10000, 1);
        out.addEmployee("Blacknoir", "Super", 10000, 1);

        Assertions.assertThrows(EmployeeStorageIsFullException.class,
                () -> out.addEmployee(EmployeeServiceImplTestConsants.jon, EmployeeServiceImplTestConsants.doe, EmployeeServiceImplTestConsants.testSalary, EmployeeServiceImplTestConsants.testDeptNumber)
        );
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedExemption() {
        Map<String, Employee> employees = new HashMap<String, Employee>();
        out.addEmployee("Homelander", "Super", 10000, 1);
        out.addEmployee("Starlight", "Super", 10000, 1);
        out.addEmployee("Stormfront", "Super", 10000, 1);
        out.addEmployee("Deep", "Super", 10000, 1);
        out.addEmployee("Translucent", "Super", 10000, 1);
        out.addEmployee("Jon", "Doe", 10000, 1);

        Assertions.assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.addEmployee(EmployeeServiceImplTestConsants.jon, EmployeeServiceImplTestConsants.doe, EmployeeServiceImplTestConsants.testSalary, EmployeeServiceImplTestConsants.testDeptNumber)
        );
    }

    @Test
    public void shouldThrowEmployeeNotFoundExeptionRemove() {
        Map<String, Employee> employees = new HashMap<String, Employee>();
        out.addEmployee("Homelander", "Super", 10000, 1);
        out.addEmployee("Starlight", "Super", 10000, 1);
        out.addEmployee("Stormfront", "Super", 10000, 1);
        out.addEmployee("Deep", "Super", 10000, 1);
        out.addEmployee("Translucent", "Super", 10000, 1);

        Assertions.assertThrows(EmployeeNotFoundExcepation.class,
                () -> out.removeEmployee(EmployeeServiceImplTestConsants.jon, EmployeeServiceImplTestConsants.doe)
        );
    }

    @Test
    public void shouldThrowEmployeeNotFoundExeptionFind() {
        Map<String, Employee> employees = new HashMap<String, Employee>();
        out.addEmployee("Homelander", "Super", 10000, 1);
        out.addEmployee("Starlight", "Super", 10000, 1);
        out.addEmployee("Stormfront", "Super", 10000, 1);
        out.addEmployee("Deep", "Super", 10000, 1);
        out.addEmployee("Translucent", "Super", 10000, 1);

        Assertions.assertThrows(EmployeeNotFoundExcepation.class,
                () -> out.findEmployee(EmployeeServiceImplTestConsants.jon, EmployeeServiceImplTestConsants.doe)
        );
    }
}

