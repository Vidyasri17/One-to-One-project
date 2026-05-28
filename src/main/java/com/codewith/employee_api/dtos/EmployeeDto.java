package com.codewith.employee_api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private String empId;
    private String empName;
    private int salary;
    private LocalDate empJoiningDate;
}
