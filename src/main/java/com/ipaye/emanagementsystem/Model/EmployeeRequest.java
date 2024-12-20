package com.ipaye.emanagementsystem.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public class EmployeeRequest {

    private final List<Employee> employeeList;


    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

    @NotNull(message = "Department ID is required")
    private Long departmentId;

    @NotNull(message = "Role ID is required")
    private Long roleId;

    @NotNull(message = "Salary is required")
    @Min(value = 0, message = "Salary must be a positive number")
    private Double salary;

    // Constructors
    public EmployeeRequest(List<Employee> employeeList) {
        this.employeeList=employeeList;
    }

    public EmployeeRequest(List<Employee> employeeList, String name, String email, Long departmentId, Long roleId, Double salary) {
        this.employeeList=employeeList;
        this.name = name;
        this.email = email;
        this.departmentId = departmentId;
        this.roleId = roleId;
        this.salary = salary;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    public Optional<Employee> findById(Long id) {
            return employeeList.stream()
                    .filter(employee -> employee.getId().equals(id))
                    .findFirst();
    }
}
