package com.codewith.employee_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewith.employee_api.dtos.LaptopDto;
import com.codewith.employee_api.service.LaptopService;

@CrossOrigin("*")
@RestController
public class LaptopController {

    @Autowired
    LaptopService laptopService;

    @PostMapping("/laptop")
    public ResponseEntity<LaptopDto> addLaptop(@RequestBody LaptopDto dto) {
        LaptopDto saved = laptopService.addLaptop(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/laptops")
    public ResponseEntity<List<LaptopDto>> getAllLaptops() {
        List<LaptopDto> list = laptopService.getAllLaptops();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/laptop/{id}")
    public ResponseEntity<LaptopDto> getLaptopById(@PathVariable String id) {
        LaptopDto dto = laptopService.getLaptopDtoById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/laptop/{id}")
    public ResponseEntity<LaptopDto> updateLaptop(@PathVariable String id,
                                                  @RequestBody LaptopDto dto) {
        LaptopDto updated = laptopService.updateLaptop(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/laptop/{id}")
    public ResponseEntity<String> deleteLaptop(@PathVariable String id) {
        String msg = laptopService.deleteLaptop(id);
        return ResponseEntity.ok(msg);
    }

    @PutMapping("/laptop/{lap_id}/employee/{emp_id}")
    public ResponseEntity<LaptopDto> assignLaptopToEmployee(
            @PathVariable String lap_id, @PathVariable String emp_id) {
        LaptopDto dto = laptopService.assignLaptopToEmployee(emp_id, lap_id);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/laptop/employee/{emp_id}")
    public ResponseEntity<LaptopDto> getLaptopByEmpId(@PathVariable String emp_id) {
        LaptopDto dto = laptopService.getLaptopByEmpId(emp_id);
        return ResponseEntity.ok(dto);
    }
}