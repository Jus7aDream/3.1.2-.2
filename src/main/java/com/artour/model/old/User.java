//package com.artour.model.old;
//
//import lombok.*;
//import lombok.extern.slf4j.Slf4j;
//
//import javax.persistence.*;
//import javax.validation.constraints.*;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
//import java.util.Objects;
//
///**
// * @ In the name of Allah, most gracious and most merciful 12.09.2022
// */
//@Entity
//@Table(name = "users")
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//@Slf4j
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @NotEmpty(message = "Username should not be empty")
//    @Size(min = 3, max = 255, message = "Username should be between 3 and 255 characters")
//    @Column(name = "username")
//    private String username;
//
//    @NotEmpty(message = "Password should not be empty")
//    @Size(min = 3, max = 255, message = "Password should be between 3 and 255 characters")
//    @Column(name = "password")
//    private String password;
//
//    @NotEmpty(message = "Name should not be empty")
//    @Size(min = 3, max = 255, message = "Name should be between 3 and 255 characters")
//    @Column(name = "name")
//    private String name;
//
//
//    @Min(value = 0, message = "Age should be greater than 0")
//    @Column(name = "age")
//    private int age;
//
//    @NotEmpty(message = "Email should be not empty")
//    @Email(message = "Email should be valid")
//    @Column(name = "email")
//    private String email;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return age == user.age && Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(email, user.email);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, username, password, name, age, email);
//    }
//}