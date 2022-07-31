package com.skypro.EmployeesListProject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private EmployeeServiceImpl employeeMock;

    @InjectMocks
    DepartmentServiceImpl out;


    @Test
    public void shouldReturnMaxAndMin() {
        when(employeeMock.printAll()).thenReturn(EmployeeServiceImplTestConsants.testList);

        assertEquals(EmployeeServiceImplTestConsants.homelander, out.findMaxEmployeeInDept(1));
        assertEquals(EmployeeServiceImplTestConsants.deep, out.findMinEmployeeInDept(1));
    }

    @Test
    public void shouldThrowExemption() {
        when(employeeMock.printAll()).thenReturn(EmployeeServiceImplTestConsants.testList);

        Assertions.assertThrows(EmployeeNotFoundExcepation.class,
                () -> out.findMaxEmployeeInDept(3)
        );
        Assertions.assertThrows(EmployeeNotFoundExcepation.class,
                () -> out.findMinEmployeeInDept(3)
        );
    }

    @Test
    public void shouldReturnDepartmentOne() {
        when(employeeMock.printAll()).thenReturn(EmployeeServiceImplTestConsants.testList);

        assertEquals(EmployeeServiceImplTestConsants.testListDept1, out.listByDept(1));
    }
}



