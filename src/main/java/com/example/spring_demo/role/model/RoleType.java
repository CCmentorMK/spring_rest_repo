package com.example.spring_demo.role.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleType {
    ADMIN("administrator"),
    USER("użytkownik");

    private final String roleName;


}
