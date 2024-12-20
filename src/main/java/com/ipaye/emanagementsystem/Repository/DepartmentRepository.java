package com.ipaye.emanagementsystem.Repository;

import com.ipaye.emanagementsystem.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.font.OpenType;
import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {


    Optional<Department> findByName (String name);




}
