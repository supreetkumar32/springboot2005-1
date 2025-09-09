package com.springbootweektwo.weektwo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springbootweektwo.weektwo.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class EmployeeDTO {
    private Long id;

    @NotBlank(message="Name is required and should not be empty")
    @Size(min=3,max=10,message="no of characters in name should be in the range [3,10")
    private String name;

    @NotBlank(message ="role should not be blank")
    @Email(message="email should be valid")
    private String email;

    @Max(value=80,message="Age cannnot be greater than 80")
    @Min(value=18,message="Age cannnot be less than 18")
    @NotNull(message="age cannot be blank")
    private Integer age;

   // @Pattern(regexp= "^(admin|user)$",message="Role of employee should be admin or user")
    @NotBlank(message ="role should not be blank")
    @EmployeeRoleValidation
    private String role;

    @NotNull(message = "Salary of Employee should be not null")
    @Positive(message = "Salary of Employee should be positive")
    @Digits(integer = 6, fraction = 2, message = "The salary can be in the form XXXXX.YY")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Double salary;

    @PastOrPresent(message = "DateOfJoining field in Employee cannot be in the future")
    private LocalDate dateOfJoining;

    @AssertTrue(message="employee should be active")
    private Boolean activeEmployee;

    public EmployeeDTO(){

    }

    public EmployeeDTO(Long id, String name, String email, Integer age,String role,Double salary, LocalDate dateOfJoining, Boolean activeEmployee) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.role=role;
        this.salary=salary;
        this.dateOfJoining = dateOfJoining;
        this.activeEmployee = activeEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Boolean getActiveEmployee() {
        return activeEmployee;
    }

    public void setActiveEmployee(Boolean active) {
        activeEmployee = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
