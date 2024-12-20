package com.ipaye.emanagementsystem.Repository;

import com.ipaye.emanagementsystem.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
