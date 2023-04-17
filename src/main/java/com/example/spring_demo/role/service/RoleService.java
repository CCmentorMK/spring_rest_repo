package com.example.spring_demo.role.service;

import com.example.spring_demo.role.model.Role;
import com.example.spring_demo.role.model.RoleType;
import com.example.spring_demo.role.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private RoleRepository roleRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Role> findRoleByRoleName(String roleName){
        return roleRepository.findFirstByRoleTypeJPQL(
                Arrays.stream(RoleType.values())
                        .filter(roleType -> roleType.getRoleName().toUpperCase().equals(roleName.toUpperCase()))
                        .findFirst().orElse(null)
        );
    }
    public List<Object[]> aggregateRoles(){
        return roleRepository.groupRolesByNameNativeSQL();
    }

}
