package com.microservice.user.Service;

import com.microservice.user.dto.UserRegistrationRecord;
import org.keycloak.representations.idm.UserRepresentation;

public interface KeyCloakUserService {
    UserRegistrationRecord createUser(UserRegistrationRecord userRegistrationRecord);
    UserRepresentation getUserById(String userId);
    void deleteUserById(String userId);
}
