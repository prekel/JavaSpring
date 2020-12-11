package com.github.prekel.JavaSpring.Lab06.component;

import com.github.prekel.JavaSpring.Lab06.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
