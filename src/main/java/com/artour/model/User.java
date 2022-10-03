package com.artour.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ In the name of Allah, most gracious and most merciful! 03.10.2022
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Username should not be empty")
    @Size(min = 3, max = 255, message = "Username should be between 3 and 255 characters")
    @Column(nullable = false, name = "username")
    private String username;

    @NotEmpty(message = "Password should not be empty")
    @Size(min = 3, max = 255, message = "Password should be between 3 and 255 characters")
    @Column(nullable = false, name = "password")
    private String password;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 3, max = 255, message = "Name should be between 3 and 255 characters")
    @Column(nullable = false, name = "name")
    private String name;


    @Min(value = 0, message = "Age should be greater than 0")
    @Column(nullable = false, name = "age")
    private int age;

    @NotEmpty(message = "Email should be not empty")
    @Email(message = "Email should be valid")
    @Column(nullable = false, name = "email")
    private String email;

    private String roles = "";
    private String permissions = "";

    public User(String username, String password, String name, int age, String email, String roles, String permissions) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.email = email;
        this.roles = roles;
        this.permissions = permissions;
    }
    public List<String> getRoleList(){
        if(roles.length()>0){
            return Arrays.asList(roles.split(","));
        }
        return new ArrayList<>();
    }
    public List<String> getPermissionList(){
        if(roles.length()>0){
            return Arrays.asList(roles.split(","));
        }
        return new ArrayList<>();
    }
}
