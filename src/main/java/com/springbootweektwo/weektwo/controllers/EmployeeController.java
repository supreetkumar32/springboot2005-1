package com.springbootweektwo.weektwo.controllers;

import com.springbootweektwo.weektwo.dto.EmployeeDTO;
import com.springbootweektwo.weektwo.entities.EmployeeEntity;
import com.springbootweektwo.weektwo.exceptions.ResourceNotFoundException;
import com.springbootweektwo.weektwo.repositories.EmployeeRepository;
import com.springbootweektwo.weektwo.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

   public EmployeeController(EmployeeService employeeService){
       this.employeeService=employeeService;
   }


//    @GetMapping("/{employeeId}")
//    public EmployeeDTO getEmployeeById(@PathVariable(name="employeeId") Long id){
//        return employeeService.getEmployeeById(id);
//    }

    @GetMapping(path="/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name="employeeId") Long id){
        Optional<EmployeeDTO> employeeDTO=employeeService.getEmployeeById(id);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found with id: "+id));
    }

//    @GetMapping
//    public List<EmployeeDTO> getAllEmployees(@RequestParam(required=false) Integer age,
//                                                @RequestParam(required=false) String sortBy){
//        return employeeService.getAllEmployees();
//    }
//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<String> handleEmployeeNotFound(NoSuchElementException exception){
//       return new ResponseEntity<>("Employee not found",HttpStatus.NOT_FOUND);
//    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required=false) Integer age,
                                             @RequestParam(required=false) String sortBy){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

//    @PostMapping
//    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
//        return employeeService.createNewEmployee(inputEmployee);
//    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee){
       EmployeeDTO savedEmployee=employeeService.createNewEmployee(inputEmployee);
       return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

//    @PutMapping(path="/{employeeId}")
//    public EmployeeDTO updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId){
//        return employeeService.updateEmployeeById(employeeId,employeeDTO);
//    }

    @PutMapping(path="/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody @Valid EmployeeDTO employeeDTO, @PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId,employeeDTO));
    }

//    @DeleteMapping(path="/{employeeId}")
//    public boolean deleteEmployeeById( @PathVariable Long employeeId){
//         return employeeService.deleteEmployeeById(employeeId);
//    }

    @DeleteMapping(path="/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById( @PathVariable Long employeeId){
       boolean gotDeleted=employeeService.deleteEmployeeById(employeeId);
        if(gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

//    @PatchMapping(path="/{employeeId}")
//    public EmployeeDTO updatePartialEmployeeById(@RequestBody Map<String,Object> updates,
//                                                 @PathVariable Long employeeId){
//        return employeeService.updatePartialEmployeeById(employeeId,updates);
//    }

    @PatchMapping(path="/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String,Object> updates,
                                                 @PathVariable Long employeeId){
       EmployeeDTO employeeDTO= employeeService.updatePartialEmployeeById(employeeId,updates);
       if(employeeDTO==null) return ResponseEntity.notFound().build();
       return ResponseEntity.ok(employeeDTO);
    }


    
}
