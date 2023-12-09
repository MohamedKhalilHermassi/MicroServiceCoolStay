package com.microservice.user.Repositories;

import com.microservice.user.entities.UserMS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserMS, String> {
}
