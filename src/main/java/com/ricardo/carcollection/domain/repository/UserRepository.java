package com.ricardo.carcollection.domain.repository;

import com.ricardo.carcollection.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByLogin(String login);

}
