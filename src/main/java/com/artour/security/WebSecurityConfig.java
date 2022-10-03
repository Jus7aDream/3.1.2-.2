package com.artour.security;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @ In the name of Allah, most gracious and most merciful! 03.10.2022
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserPrincipalDetailsService userPrincipalDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/index.html").permitAll()
                .antMatchers("/profile/**", "/api/public/users").authenticated()
//                .antMatchers("/profile/index").hasRole("USER")   //работает
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER")
                .antMatchers("/api/public/test1").hasAuthority("ACCESS_TEST1")
                .antMatchers("/api/public/test2").hasAuthority("ACCESS_TEST2")
                .antMatchers("/api/public/users").hasRole("ADMIN")
//                .antMatchers("/api/public/test1").authenticated()
//                .antMatchers("/api/public/test2").authenticated()
                .antMatchers("/api/public/**").authenticated()
//                .antMatchers("/api/public/**").hasRole("ADMIN")
//                .anyRequest().authenticated() //доступ для авторизованных пользователей
//                .anyRequest().permitAll() //доступ для всех пользователей
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                .and()
                .rememberMe().tokenValiditySeconds(2592000).key("mySecret!");
//                .and()
//                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    DaoAuthenticationProvider daoAuthProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userPrincipalDetailsService);
        return daoAuthenticationProvider;
    }

    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin")
//                .password(passwordEncoder().encode("admin"))
////                .roles("ADMIN")
////                .roles("ADMIN").authorities("ACCESS_TEST1", "ACCESS_TEST2")
//                .authorities("ROLE_ADMIN", "ACCESS_TEST1", "ACCESS_TEST2")
//
//                .and()
//
//                .withUser("manager")
//                .password(passwordEncoder().encode("manager"))
////                .roles("MANAGER")
////                .roles("MANAGER").authorities("ACCESS_TEST1")
//                .authorities("ROLE_MANAGER", "ACCESS_TEST1")
//
//                .and()
//
//                .withUser("user")
//                .password(passwordEncoder().encode("user"))
//                .roles("USER");
//    }
}
