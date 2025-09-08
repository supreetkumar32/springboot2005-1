package com.springbootweektwo.weektwo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    private Boolean activeEmployee;

    public EmployeeDTO(){

    }

    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dateOfJoining, Boolean activeEmployee) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
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
}
