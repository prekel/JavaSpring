package com.github.prekel.JavaSpring.Lab06.component;

import com.github.prekel.JavaSpring.Lab06.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
