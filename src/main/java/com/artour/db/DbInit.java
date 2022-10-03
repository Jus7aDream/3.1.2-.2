package com.artour.db;

import com.artour.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
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

    @Override
    public void run(String... args) {
        User artour = new User(
                "artour",
                "artour",
                "artour",
                33,
                "x@gmail.com",
                "USER",
                "");
        User admin = new User(
                "admin",
                "admin",
                "admin",
                33,
                "admin@gmail.com",
                "ADMIN",
                "ACCESS_TEST1, ACCESS_TEST2");
        User manager = new User(
                "manager",
                "manager",
                "manager",
                33,
                "manager@gmail.com",
                "MANAGER",
                "ACCESS_TEST1");
        User user = new User(
                "user",
                "user",
                "user",
                33,
                "user@gmail.com",
                "USER",
                "");
        List<User> users = Arrays.asList(artour, admin, manager, user);
        userRepository.saveAll(users);
    }
}
