package com.example.spring_demo.user.model;

import com.example.spring_demo.post.Post;
import com.example.spring_demo.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data                       // dodaje gettery, settery & toString
//@AllArgsConstructor         // dodaje konstruktor z wszystkimi polami w argumentach
@NoArgsConstructor          // dodaje konstruktor domyślny
public class User {         // klasa modelu determinująca strukturę danych
    @Id                                                     // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // AI
    private int userId;
//    @Pattern(regexp = )   -> custom validation based on regex
    @Email
//    @Type(value = "text") -> to do ???
    private String email;
    @NotBlank                                               // NotNull
    private String password;
    @ManyToMany                                             // N:M
    @JoinTable
    private Set<Role> roles = new HashSet<>();
//    @OneToMany                                              // 1:N
//    private List<Post> posts = new ArrayList<>();

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
