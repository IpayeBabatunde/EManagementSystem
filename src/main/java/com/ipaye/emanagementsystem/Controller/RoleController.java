package com.ipaye.emanagementsystem.Controller;


import com.ipaye.emanagementsystem.Model.Role;
import com.ipaye.emanagementsystem.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();

    }

    @GetMapping("{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id){
        return roleService.getRoleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        Role createdRole = roleService.createRole(role);
        return ResponseEntity.status(201).body(createdRole);
    }

    @PutMapping("{id}")
    public ResponseEntity<Role> updateRole(
            @PathVariable Long id,
            @RequestBody Role roleDetails){
        return ResponseEntity.ok(roleService.updateRole(id, roleDetails));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
