package com.ipaye.emanagementsystem;

import com.ipaye.emanagementsystem.Model.Employee;
import com.ipaye.emanagementsystem.Repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class RepositoryLayerTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void saveEmployeeShouldPersistData(){
        // Arrange
        Employee employee = new Employee(1L, "John Doe", "john.doe@gmail.com", 2L, 3L,40.0000);

        // Act
        Employee savedEmployee = employeeRepository.save(employee);

        //Assert
        assertEquals("John Doe", savedEmployee.getName());

    }


    @Test
    public void findByDepartmentIdShouldReturnEmployees(){
        // Arrange
        Employee employee = new Employee(1L, "John Doe", "Johndoe@gmail.com", 1L, 2L, 40.0000);
        employeeRepository.save(employee);

        // Act
        List<Employee> employees = employeeRepository.findDepartmentById(1);

        // Assert
        assertEquals(1, employees.size());
        assertEquals("John doe", employees.get(0).getName());
    }
}
