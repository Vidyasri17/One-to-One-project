package com.codewith.employee_api.repository;

import com.codewith.employee_api.Entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LaptopRepository extends JpaRepository<Laptop, String> {
    @Query("SELECT l FROM Laptop l WHERE l.employee.empId = :empId")
    Laptop getLaptopByEmpId(@Param("empId") String empId);
}
