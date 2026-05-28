package com.codewith.employee_api.service;

import com.codewith.employee_api.Entity.Employee;
import com.codewith.employee_api.Entity.Laptop;
import com.codewith.employee_api.dtos.EmployeeDto;
import com.codewith.employee_api.dtos.LaptopDto;
import com.codewith.employee_api.repository.EmployeeRepository;
import com.codewith.employee_api.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LaptopServiceImpl implements LaptopService {
    @Autowired
    LaptopRepository laptopRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @Override
    public LaptopDto addLaptop(LaptopDto laptopDto) {
        if(laptopRepository.findById(laptopDto.getLapId()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Laptop already exists with id: " + laptopDto.getLapId());
        }
        Laptop laptop = new Laptop(laptopDto.getLapId(), laptopDto.getLapName(), laptopDto.getLapModel(), laptopDto.getLapWarranty());
        laptopRepository.save(laptop);
        return laptopDto;
    }

    @Override
    public LaptopDto getLaptopDtoById(String id) {
        Laptop laptop = laptopRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Laptop not found with id: " + id));
        String empId = laptop.getEmployee() != null ? laptop.getEmployee().getEmpId() : null;
        return  new LaptopDto(laptop.getLapId(), laptop.getLapName(), laptop.getLapModel(), laptop.getLapWarranty(), empId);
    }

    @Override
    public List<LaptopDto> getAllLaptops() {
        List<Laptop> laptops = laptopRepository.findAll();
        if(laptops.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No laptops found");
        }
        return laptops.stream()
                .map(l -> {
                    String empId = l.getEmployee() != null ? l.getEmployee().getEmpId() : null;
                    return new LaptopDto(l.getLapId(), l.getLapName(), l.getLapModel(), l.getLapWarranty(), empId);
                })
                .collect(Collectors.toList());
    }

    @Override
    public LaptopDto updateLaptop(String id, LaptopDto laptopDto) {
        Laptop existing = laptopRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Laptop not found with id: " + id));
        if(laptopDto.getLapName() != null) {
            existing.setLapName(laptopDto.getLapName());
        }
        if(laptopDto.getLapModel() != null) {
            existing.setLapModel(laptopDto.getLapModel());
        }
        if(laptopDto.getLapWarranty() != null) {
            existing.setLapWarranty(laptopDto.getLapWarranty());
        }
        laptopRepository.save(existing);
        String empId = existing.getEmployee() != null ? existing.getEmployee().getEmpId() : null;
        return new LaptopDto(existing.getLapId(), existing.getLapName(), existing.getLapModel(), existing.getLapWarranty(), empId);
    }

    @Override
    public String deleteLaptop(String id){
        if(laptopRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Laptop not found with id: " + id);
        }
        laptopRepository.deleteById(id);
        return "Laptop with id: " + id + " has been deleted";
    }

    @Override
    public LaptopDto assignLaptopToEmployee(String empId, String lapId) {
        Laptop laptop = laptopRepository.findById(lapId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Laptop not found with id: " + lapId));
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found with id: " + empId));
        laptop.setEmployee(employee);
        laptopRepository.save(laptop);
        return new LaptopDto(laptop.getLapId(), laptop.getLapName(), laptop.getLapModel(), laptop.getLapWarranty(), empId);
    }

    @Override
    public LaptopDto getLaptopByEmpId(String empId) {
        Laptop laptop = laptopRepository.getLaptopByEmpId(empId);
        if(laptop == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Laptop is not assigned to employee with id: " + empId);
        }
        return new LaptopDto(laptop.getLapId(), laptop.getLapName(), laptop.getLapModel(), laptop.getLapWarranty(), empId);
    }
}
