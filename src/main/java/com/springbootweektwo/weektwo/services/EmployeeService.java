package com.springbootweektwo.weektwo.services;

import com.springbootweektwo.weektwo.dto.EmployeeDTO;
import com.springbootweektwo.weektwo.entities.EmployeeEntity;
import com.springbootweektwo.weektwo.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    
    public EmployeeService(EmployeeRepository employeeRepository,ModelMapper modelMapper){
        this.employeeRepository=employeeRepository;
        this.modelMapper=modelMapper;
    }
    
    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity=employeeRepository.findById(id).orElse(null);
        return modelMapper.map(employeeEntity,EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities=employeeRepository.findAll();
        return employeeEntities.stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
        EmployeeEntity toSaveEntity=modelMapper.map(inputEmployee,EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity=employeeRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity,EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(Long employeeId,EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity=modelMapper.map(employeeDTO,EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity=employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity,EmployeeDTO.class);
    }

    public boolean isExistsByEmployeeId(Long employeeId){
        return employeeRepository.existsById(employeeId);
    }

    public boolean deleteEmployeeById(Long employeeId) {
        boolean exists=isExistsByEmployeeId(employeeId);
        if(!exists) return false;
        employeeRepository.deleteById(employeeId);
        return true;
    }

    public EmployeeDTO updatePartialEmployeeById(Long employeeId, Map<String, Object> updates) {
        boolean exists=isExistsByEmployeeId(employeeId);
        if(!exists) return null;
        EmployeeEntity employeeEntity=employeeRepository.findById(employeeId).get();

        // Apply partial updates
        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
        });
        // Save & return DTO
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
