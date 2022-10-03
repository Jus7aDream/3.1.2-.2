package com.artour.db;

import com.artour.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @ In the name of Allah, most gracious and most merciful! 03.10.2022
 */
@Service
@RequiredArgsConstructor
public class DbInit implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        userRepository.deleteAll();
        User admin = new User(
                "admin",
                passwordEncoder.encode("admin"),
                "admin",
                33,
                "admin@gmail.com",
                "ADMIN",
                "ACCESS_TEST1, ACCESS_TEST2");
        User manager1 = new User(
                "manager1",
                passwordEncoder.encode("manager1"),
                "manager1",
                33,
                "manager@gmail.com",
                "MANAGER",
                "ACCESS_TEST1");
        User manager2 = new User(
                "manager2",
                passwordEncoder.encode("manager2"),
                "manager2",
                33,
                "manager2@gmail.com",
                "MANAGER",
                "ACCESS_TEST2");
        User user = new User(
                "user",
                passwordEncoder.encode("user"),
                "user",
                33,
                "user@gmail.com",
                "USER",
                "");
        List<User> users = Arrays.asList(admin, manager1, manager2, user);
        userRepository.saveAll(users);
    }
}
