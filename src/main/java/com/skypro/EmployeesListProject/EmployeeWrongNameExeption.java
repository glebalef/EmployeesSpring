package com.skypro.EmployeesListProject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.BAD_REQUEST, reason = "Forbidden name!")
public class EmployeeWrongNameExeption extends RuntimeException {
    public EmployeeWrongNameExeption() {
        super();
    }
}