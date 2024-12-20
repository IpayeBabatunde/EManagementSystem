package com.ipaye.emanagementsystem.Repository;

import com.ipaye.emanagementsystem.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findDepartmentById(int id);


//    List<Employee> findByDepartmentId(Long departmentId);
//
//    // Custom query to find employees by role ID
//    List<Employee> findByRoleId(Long roleId);
//
//    // Custom query to find employees with a specific name
//    List<Employee> findByNameContaining(String name);

}
