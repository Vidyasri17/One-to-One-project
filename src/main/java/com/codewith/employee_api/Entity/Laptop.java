package com.codewith.employee_api.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "laptop")
public class Laptop {
    @Id
    @Column(name = "lap_id")
    private int lapId;

    @Column(name = "lap_name", nullable = false)
    private String lapName;

    @Column(name = "lap_model", nullable = false)
    private String lapModel;

    @Column(name = "lap_warranty", nullable = false)
    private String lapWarranty;

    @Column(name = "emp_id")
    private int empId;

    public Laptop() {
    }

    public Laptop(int lapId, String lapName, String lapModel, String lapWarranty, int empId) {
        this.lapId = lapId;
        this.lapName = lapName;
        this.lapModel = lapModel;
        this.lapWarranty = lapWarranty;
        this.empId = empId;
    }

    public int getLapId() {
        return lapId;
    }

    public void setLapId(int lapId) {
        this.lapId = lapId;
    }

    public String getLapName() {
        return lapName;
    }

    public void setLapName(String lapName) {
        this.lapName = lapName;
    }

    public String getLapModel() {
        return lapModel;
    }

    public void setLapModel(String lapModel) {
        this.lapModel = lapModel;
    }

    public String getLapWarranty() {
        return lapWarranty;
    }

    public void setLapWarranty(String lapWarranty) {
        this.lapWarranty = lapWarranty;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String toString() {
        return "Laptop [lapId=" + lapId + ", lapName=" + lapName + ", lapModel=" + lapModel
                + ", lapWarranty=" + lapWarranty + ", empId=" + empId + "]";
    }
}
