package com.codewith.employee_api.service;
import java.util.ArrayList;
import java.util.List;
import com.codewith.employee_api.dtos.LaptopDto;
public interface LaptopService {
    LaptopDto addLaptop(LaptopDto laptopDto);
    LaptopDto getLaptopDtoById(String id);
    List<LaptopDto> getAllLaptops();
    LaptopDto updateLaptop(String id, LaptopDto laptopDto);
    String deleteLaptop(String id);
    LaptopDto assignLaptopToEmployee(String empId, String lapId);
    LaptopDto getLaptopByEmpId(String empId);
}
