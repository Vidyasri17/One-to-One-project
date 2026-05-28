package com.codewith.employee_api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @Column(name = "emp_id")
    private String empId;

    @Column(name = "emp_name", nullable = false)
    private String empName;

    @Column(name = "salary")
    private int salary;

    @Column(name = "emp_joining_date", columnDefinition = "DATE DEFAULT (CURRENT_DATE)")
    private LocalDate empJoiningDate;

    @OneToOne(mappedBy = "employee")
    @ToString.Exclude
    private Laptop laptop;

    public Employee(String empId, String empName, int salary, LocalDate empJoiningDate) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.empJoiningDate = empJoiningDate;
    }
}
