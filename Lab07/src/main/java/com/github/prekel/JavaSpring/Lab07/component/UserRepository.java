package com.github.prekel.JavaSpring.Lab07.component;

import com.github.prekel.JavaSpring.Lab07.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
