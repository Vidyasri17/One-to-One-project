package com.codewith.employee_api.repository;
import com.codewith.employee_api.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    
}