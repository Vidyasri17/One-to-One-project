//package com.codewith.employee_api.service;
//
//import com.codewith.employee_api.Entity.Employee;
//import com.codewith.employee_api.Entity.Laptop;
//import com.codewith.employee_api.repository.EmployeeRepository;
//import com.codewith.employee_api.repository.LaptopRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class Operations {
//    private final EmployeeRepository employeeRepository;
//    private final LaptopRepository laptopRepository;
//
//    public Operations(EmployeeRepository employeeRepository, LaptopRepository laptopRepository) {
//        this.employeeRepository = employeeRepository;
//        this.laptopRepository = laptopRepository;
//    }
//
//    public boolean addEmployee(Employee emp) {
//        if (employeeRepository.existsById(emp.getEmpId())) {
//            return false;
//        }
//        employeeRepository.save(emp);
//        return true;
//    }
//
//    public Employee getEmployeeById(int id) {
//        return employeeRepository.findById(id).orElse(null);
//    }
//
//    public List<Employee> getAllEmployees() {
//        return employeeRepository.findAll();
//    }
//
//    public Employee updateEmployeeName(int id, String name) {
//        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
//        if (existingEmployee != null) {
//            existingEmployee.setEmpName(name);
//            return employeeRepository.save(existingEmployee);
//        }
//        return null;
//    }
//
//    public boolean deleteEmployee(int id) {
//        if (employeeRepository.existsById(id)) {
//            employeeRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }
//
//    public boolean addLaptop(Laptop lap) {
//        if (laptopRepository.existsById(lap.getLapId())) {
//            return false;
//        }
//        laptopRepository.save(lap);
//        return true;
//    }
//
//    public Laptop getLaptopById(int id) {
//        return laptopRepository.findById(id).orElse(null);
//    }
//
//    public List<Laptop> getAllLaptops() {
//        return laptopRepository.findAll();
//    }
//
//    public Laptop updateLaptopModel(int id, String name) {
//        Laptop existingLaptop = laptopRepository.findById(id).orElse(null);
//        if (existingLaptop != null) {
//            existingLaptop.setLapModel(name);
//            return laptopRepository.save(existingLaptop);
//        }
//        return null;
//    }
//
//    public boolean deleteLaptop(int id) {
//        if (laptopRepository.existsById(id)) {
//            laptopRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }
//}
