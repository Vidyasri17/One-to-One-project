package com.codewith.employee_api.service;
import com.codewith.employee_api.dtos.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto addEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeDtoById(String id);
    EmployeeDto updateEmployee(String id, EmployeeDto employeeDto);
    String deleteEmployee(String id);
}