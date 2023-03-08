package com.example.spring_demo.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                       // dodaje gettery, settery & toString
@AllArgsConstructor         // dodaje konstruktor z wszystkimi polami w argumentach
@NoArgsConstructor          // dodaje konstruktor domyślny
public class User {         // klasa modelu determinująca strukturę danych
    private int userId;
    private String email;
    private String password;
}
