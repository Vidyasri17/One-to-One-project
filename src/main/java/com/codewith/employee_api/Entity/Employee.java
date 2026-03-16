package com.codewith.employee_api.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "emp_id")
    private int empId;

    @Column(name = "emp_name", nullable = false)
    private String empName;

    @Column(name = "salary")
    private int salary;

    @Column(name = "emp_joining_date", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private String empJoiningDate;

    public Employee() {
    }

    public Employee(int empId, String empName, int salary, String empJoiningDate) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.empJoiningDate = empJoiningDate;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmpJoiningDate() {
        return empJoiningDate;
    }

    public void setEmpJoiningDate(String empJoiningDate) {
        this.empJoiningDate = empJoiningDate;
    }

    public String toString() {
        return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary
                + ", empJoiningDate=" + empJoiningDate + "]";
    }
}
