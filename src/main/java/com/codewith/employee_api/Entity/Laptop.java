package com.codewith.employee_api.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Laptop {
    @Id
    private int laptopId;
    private String laptopName;
    private String laptopModel;
    private int warranty;
    private int employeeId;

    public Laptop() {
    }

    public Laptop(int laptopId, String laptopName, String laptopModel, int warranty, int employeeId) {
        this.laptopId = laptopId;
        this.laptopName = laptopName;
        this.laptopModel = laptopModel;
        this.warranty = warranty;
        this.employeeId = employeeId;
    }

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public String getLaptopModel() {
        return laptopModel;
    }

    public void setLaptopModel(String laptopModel) {
        this.laptopModel = laptopModel;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String toString() {
        return "Laptop [laptopId=" + laptopId + ", laptopName=" + laptopName + ", laptopModel=" + laptopModel
                + ", warranty=" + warranty + ", employeeId=" + employeeId + "]";
    }
}
