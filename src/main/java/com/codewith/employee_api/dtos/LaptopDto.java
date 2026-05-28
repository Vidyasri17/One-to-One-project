package com.codewith.employee_api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaptopDto {
    private String lapId;
    private String lapName;
    private String lapModel;
    private String lapWarranty;
    private String empId;
}
