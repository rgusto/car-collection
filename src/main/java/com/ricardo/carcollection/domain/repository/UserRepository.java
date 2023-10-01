package com.ricardo.carcollection.domain.repository;

import com.ricardo.carcollection.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {


}
