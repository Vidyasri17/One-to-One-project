package com.codewith.employee_api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "laptop")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Laptop {
    @Id
    @Column(name = "lap_id")
    private String lapId;

    @Column(name = "lap_name", nullable = false)
    private String lapName;

    @Column(name = "lap_model", nullable = false)
    private String lapModel;

    @Column(name = "lap_warranty", nullable = false)
    private String lapWarranty;

    @OneToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    // Manual constructor for the one used in LaptopServiceImpl
    public Laptop(String lapId, String lapName, String lapModel, String lapWarranty) {
        this.lapId = lapId;
        this.lapName = lapName;
        this.lapModel = lapModel;
        this.lapWarranty = lapWarranty;
    }
}
