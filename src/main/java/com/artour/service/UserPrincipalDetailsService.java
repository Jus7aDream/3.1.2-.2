package com.artour.service;

import com.artour.db.UserRepository;
import com.artour.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @ In the name of Allah, most gracious and most merciful! 03.10.2022
 */
@RequiredArgsConstructor
public class UserPrincipalDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
//        UserPrincipal userPrincipal = new UserPrincipal(user);
//        return userPrincipal;
        return new UserPrincipal(user);
    }
}
