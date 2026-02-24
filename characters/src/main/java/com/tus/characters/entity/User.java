package com.tus.characters.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users") // maps to the MySQL/H2 users table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(name = "mobile_number", length = 20, nullable = true) // optional
    private String mobileNumber;

    // BaseEntity likely contains created_at, created_by, updated_at, updated_by
    // If not, you can define them here

    // One user can have many characters
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Character> characters;
    
    
}