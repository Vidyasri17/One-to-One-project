package com.codewith.employee_api.repository;

import com.codewith.employee_api.Entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {
}
