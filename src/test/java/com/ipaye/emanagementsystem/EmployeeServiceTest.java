package com.ipaye.emanagementsystem;

import com.ipaye.emanagementsystem.Model.Employee;
import com.ipaye.emanagementsystem.Repository.DepartmentRepository;
import com.ipaye.emanagementsystem.Repository.EmployeeRepository;
import com.ipaye.emanagementsystem.Repository.RoleRepository;
import com.ipaye.emanagementsystem.Service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private DepartmentRepository departmentRepository;

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void createEmployeeShouldSaveEmployee(){

        //Arrange
        Employee employee = new Employee(1L, "John Doe", "john.doe@gmail.com", 1L, 8L, 70.000);
        Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);

        // Act
        Employee createdEmployee = employeeService.createEmployee(employee);

        // Assert
        assertNotNull(createdEmployee);
        assertEquals("John Doe", createdEmployee.getName());
        Mockito.verify(employeeRepository, Mockito.times(1)).save(Mockito.any(Employee.class));
    }


    @Test
    public void getAllEmployeesShouldReturnListOfEmployees(){
        // Arrange
        List<Employee> employees =Arrays.asList(
                new Employee(1L, "John Doe", "John.doe@example.com", 1L, 2L, 70.0000),
                new Employee(2L, "Jane Doe", "Jane.doe@example.com", 8L, 9L, 1000.0000)

        );
        Mockito.when(employeeRepository.findAll()).thenReturn(employees);

        // Act
        List<Employee> result = employeeService.getAllEmployee();

        //Assert
        assertEquals(2, result.size());
        Mockito.verify(employeeRepository, Mockito.times(1)).findAll();
    }

}
