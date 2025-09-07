package com.springbootweektwo.weektwo.controllers;

import com.springbootweektwo.weektwo.dto.EmployeeDTO;
import com.springbootweektwo.weektwo.entities.EmployeeEntity;
import com.springbootweektwo.weektwo.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

//    @GetMapping(path="/getSecretMessage")
//    public String getMySuperSecretMessage(){
//        return "secret message";
//    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name="employeeId") Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required=false) Integer age,
                                                @RequestParam(required=false) String sortBy){
        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
        return employeeRepository.save(inputEmployee);
    }

    @PutMapping
    public String updateEmployeeById(){
        return "Namaste from put";
    }

    
}
