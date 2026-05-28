package com.codewith.employee_api.service;

import com.codewith.employee_api.Entity.Employee;
import com.codewith.employee_api.dtos.EmployeeDto;
import com.codewith.employee_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto addEmployee(EmployeeDto dto){
        if(employeeRepository.findById(dto.getEmpId()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Employee already exists with id: " + dto.getEmpId());
        }
        Employee employee = new Employee(dto.getEmpId(), dto.getEmpName(), dto.getSalary(), dto.getEmpJoiningDate());
        employeeRepository.save(employee);
        return dto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        if(employees.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No employees found");
        }
        return employees.stream()
                .map(e -> new EmployeeDto(e.getEmpId(), e.getEmpName(), e.getSalary(), e.getEmpJoiningDate()))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeDtoById(String id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found with id: " + id));
        return new EmployeeDto(employee.getEmpId(), employee.getEmpName(), employee.getSalary(), employee.getEmpJoiningDate());
    }

    @Override
    public EmployeeDto updateEmployee(String id, EmployeeDto employeeDto) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found with id: " + id));
        if (employeeDto.getEmpName() != null) {
            existingEmployee.setEmpName(employeeDto.getEmpName());
        }
        if(employeeDto.getEmpJoiningDate() != null) {
            existingEmployee.setEmpJoiningDate(employeeDto.getEmpJoiningDate());
        }
        if(employeeDto.getSalary() != 0){
            existingEmployee.setSalary(employeeDto.getSalary());
        }
        employeeRepository.save(existingEmployee);
        return new EmployeeDto(existingEmployee.getEmpId(), existingEmployee.getEmpName(), existingEmployee.getSalary(), existingEmployee.getEmpJoiningDate());
    }

    @Override
    public String deleteEmployee(String empId){
        if(employeeRepository.findById(empId).isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found with id: " + empId);
        employeeRepository.deleteById(empId);
        return "Employee with id: " + empId + " has been deleted";
    }
}
