package com.ipaye.emanagementsystem.Service;


import com.ipaye.emanagementsystem.Model.Role;
import com.ipaye.emanagementsystem.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long id){
        return roleRepository.findById(id);
    }

    public Role createRole(Role role){
        return roleRepository.save(role);
    }

    public Role updateRole(Long id, Role roleDetails){
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        role.setName(roleDetails.getName());
        role.setDescription(roleDetails.getDescription());
        return roleRepository.save(role);
    }

    public void deleteRole(Long id){
        if (!roleRepository.existsById(id)){
            throw new RuntimeException("Role not found");
        }
        roleRepository.deleteById(id);
    }
}
