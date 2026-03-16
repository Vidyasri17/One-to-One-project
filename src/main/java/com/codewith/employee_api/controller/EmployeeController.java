package com.codewith.employee_api.controller;

import com.codewith.employee_api.Entity.Employee;
import com.codewith.employee_api.Entity.Laptop;
import com.codewith.employee_api.service.Operations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final Operations operations;

    public EmployeeController(Operations operations) {
        this.operations = operations;
    }

    @PostMapping("/employees/add")
    public Employee createEmployee(@RequestBody Employee employee) {
        return operations.createEmployee(employee);
    }

    @GetMapping("/employees/get/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return operations.getEmployeeById(id);
    }

    @GetMapping("/employees/getAll")
    public List<Employee> getAllEmployees() {
        return operations.getAllEmployees();
    }

    @PutMapping("/employees/updateName/{id}")
    public Employee updateEmployeeName(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        return operations.updateEmployeeName(id, updatedEmployee);
    }

    @DeleteMapping("/employees/delete/{id}")
    public boolean deleteEmployee(@PathVariable int id) {
        return operations.deleteEmployee(id);
    }

    @PostMapping("/laptops/add")
    public Laptop addLaptop(@RequestBody Laptop laptop) {
        return operations.addLaptop(laptop);
    }

    @GetMapping("/laptops/get/{id}")
    public Laptop getLaptopById(@PathVariable int id) {
        return operations.getLaptopById(id);
    }

    @GetMapping("/laptops/getAll")
    public List<Laptop> getAllLaptops() {
        return operations.getAllLaptops();
    }

    @PutMapping("/laptops/update/{id}")
    public Laptop updateLaptop(@PathVariable int id, @RequestBody Laptop updatedLaptop) {
        return operations.updateLaptop(id, updatedLaptop);
    }

    @DeleteMapping("/laptops/delete/{id}")
    public boolean deleteLaptop(@PathVariable int id) {
        return operations.deleteLaptop(id);
    }
}
