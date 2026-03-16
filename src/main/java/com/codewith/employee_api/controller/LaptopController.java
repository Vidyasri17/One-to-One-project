package com.codewith.employee_api.controller;

import com.codewith.employee_api.Entity.Laptop;
import com.codewith.employee_api.service.Operations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController {
    private final Operations operations;

    public LaptopController(Operations operations) {
        this.operations = operations;
    }

    @PostMapping("/add")
    public boolean addLaptop(@RequestBody Laptop lap) {
        return operations.addLaptop(lap);
    }

    @GetMapping("/get/{id}")
    public Laptop getLaptopById(@PathVariable int id) {
        return operations.getLaptopById(id);
    }

    @GetMapping("/getAll")
    public List<Laptop> getAllLaptops() {
        return operations.getAllLaptops();
    }

    @PutMapping("/updateName/{id}")
    public Laptop updateModelById(@PathVariable int id, @RequestBody String name) {
        return operations.updateLaptopModel(id, name);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteLaptop(@PathVariable int id) {
        return operations.deleteLaptop(id);
    }
}