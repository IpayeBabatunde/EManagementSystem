package com.ipaye.emanagementsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "employees")

public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message= "Name is required")
    @Column(nullable=false)
    private String name;

    @Email(message="Email should be valid")
    @NotBlank(message="Email is required")
    @Column(nullable=false, unique=true)
    private String email;

    @NotNull(message="Department ID is required")
    @Column(name = "department_id", nullable=false)
    private Long departmentId;

    @NotNull(message="Role id is required")
    @Column(name="Role_id", nullable=false)
    private Long roleId;

    @NotNull(message="Salary is required")
    @Min(value=0, message="Salary must be a positive number")
    @Column(nullable=false)
    private Double salary;

    // constructors
//    public Employee(){}

    public Employee(Long id, String name, String email, Long departmentId, Long roleId, Double salary){
                this.id = id;
                this.email = email;
                this.departmentId = departmentId;
                this.roleId = roleId;
                this.salary = salary;
    }

    public Employee() {

    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long  departmentId) {
        this.departmentId=departmentId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId=roleId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary=salary;
    }
}

