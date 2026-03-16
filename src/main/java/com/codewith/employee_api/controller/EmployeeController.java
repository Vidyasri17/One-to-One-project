package com.codewith.employee_api.controller;

import com.codewith.employee_api.Entity.Employee;
import com.codewith.employee_api.service.Operations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final Operations operations;

    public EmployeeController(Operations operations) {
        this.operations = operations;
    }

    @PostMapping("/add")
    public boolean addEmployee(@RequestBody Employee emp) {
        return operations.addEmployee(emp);
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeeeById(@PathVariable int id) {
        return operations.getEmployeeById(id);
    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployees() {
        return operations.getAllEmployees();
    }

    @PutMapping("/updateName/{id}")
    public Employee updateNameById(@PathVariable int id, @RequestBody String name) {
        return operations.updateEmployeeName(id, name);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable int id) {
        return operations.deleteEmployee(id);
    }
}
