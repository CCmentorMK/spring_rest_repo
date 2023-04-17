package com.example.spring_demo.role.controller;

import com.example.spring_demo.role.model.Role;
import com.example.spring_demo.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping("/roleTypes")
    public List<Object[]> aggregateRoles(){
        return roleService.aggregateRoles();
    }
    @GetMapping("/getRoleByName")
    public Optional<Role> getRoleByRoleName(
            @RequestParam String roleName){
        return roleService.findRoleByRoleName(roleName);
    }
}
