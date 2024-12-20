package com.ipaye.emanagementsystem.Service;


import com.ipaye.emanagementsystem.Model.Department;
import com.ipaye.emanagementsystem.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Long id){
        return departmentRepository.findById(id);
    }

    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department departmentDetails){
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        department.setName(departmentDetails.getName());
        department.setDescription(departmentDetails.getDescription());
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id){
        if (!departmentRepository.existsById(id)){
            throw new RuntimeException("Department not found");

        }
        departmentRepository.deleteById(id);
    }
}
