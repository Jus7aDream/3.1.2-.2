package com.artour.repo;

import com.artour.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @ In the name of Allah, most gracious and most merciful! 29.09.2022
 */
@Repository
@Transactional
public interface UserRepo extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.name=?1")
    List<User> findByName(User name);
}
