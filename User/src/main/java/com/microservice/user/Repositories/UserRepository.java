package com.microservice.user.Repositories;

import com.microservice.user.entities.UserMS;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserMS, Long> {

    UserMS findByFirstName(String firstName);

}
