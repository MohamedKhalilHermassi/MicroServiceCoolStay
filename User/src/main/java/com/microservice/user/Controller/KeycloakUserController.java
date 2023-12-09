package com.microservice.user.Controller;

import com.microservice.user.Service.KeyCloakUserService;
import com.microservice.user.Service.KeyCloakUserServiceImpl;
import com.microservice.user.dto.UserRegistrationRecord;
import lombok.AllArgsConstructor;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class KeycloakUserController {
    private final KeyCloakUserServiceImpl keyCloakUserServiceImpl;

    @PostMapping
    public UserRegistrationRecord creatUser(@RequestBody UserRegistrationRecord userRegistrationRecord){
        return keyCloakUserServiceImpl.createUser(userRegistrationRecord);
    }

    @GetMapping("/{user-id}")
    public UserRepresentation getUser(@PathVariable(name = "user-id") String userId){
        return keyCloakUserServiceImpl.getUserById(userId);
    }

    @DeleteMapping("/{user-id}")
    public void deleteUserById(@PathVariable(name = "user-id") String userId){
        keyCloakUserServiceImpl.deleteUserById(userId);
    }
}
