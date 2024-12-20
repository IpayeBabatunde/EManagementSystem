package com.ipaye.emanagementsystem.Controller;

import com.ipaye.emanagementsystem.Model.Employee;
import com.ipaye.emanagementsystem.Model.EmployeeRequest;
import com.ipaye.emanagementsystem.Service.EmployeeService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;


@SpringBootApplication
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

   private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService=employeeService;
    }

    //  create an employee
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createEmployee(@RequestBody Employee employeeRequest){
        Employee createdEmployee = employeeService.createEmployee(employeeRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("id", createdEmployee.getId(), "message", "Employee created successfully"));
    }

    //Get all Employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // Get Employee By Id
    @GetMapping("{Id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long Id){
        Employee employee = employeeService.getEmployeeById(Id);
        return ResponseEntity.ok(employee);
    }

    // update an Employee
    @PutMapping ("{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequest employeeRequest
    ){
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeRequest);
        return ResponseEntity.ok(updatedEmployee);
    }

    // delete an Employee
    @DeleteMapping("{id}")
   // @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){

        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();

    }

}
