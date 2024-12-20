package com.ipaye.emanagementsystem.Service;

import com.ipaye.emanagementsystem.Model.Employee;
import com.ipaye.emanagementsystem.Model.EmployeeRequest;
import com.ipaye.emanagementsystem.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository=employeeRepository;
    }

    public Employee createEmployee(Employee employeeRequest) {
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setDepartmentId(employeeRequest.getDepartmentId());
        employee.setRoleId(employeeRequest.getRoleId());
        employee.setSalary(employeeRequest.getSalary());

        return employeeRepository.save(employee);

    }

    public List<Employee> getAllEmployee(){
     return new ArrayList<>(employeeRepository.findAll());
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee updateEmployee(Long id, EmployeeRequest employeeRequest){
        Employee employee =(Employee) employeeRequest.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setName(employeeRequest.getName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setDepartmentId(employeeRequest.getDepartmentId());
        employee.setRoleId(employeeRequest.getRoleId());
        employee.setSalary(employeeRequest.getSalary());

        return employeeRepository.save(employee);
    }
    public void deleteEmployee(Long id){
        if(!employeeRepository.existsById(id)){
            throw new RuntimeException("Employee not found");
        }
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllEmployees() {

        return new ArrayList<>(employeeList);
    }
}
