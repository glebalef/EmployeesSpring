package com.skypro.EmployeesListProject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Employee not found")
public class EmployeeNotFoundExcepation extends RuntimeException {
        public EmployeeNotFoundExcepation() {
            super();
        }
    }
