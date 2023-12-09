package com.microservice.user.Service;

import com.microservice.user.Repositories.UserRepository;
import com.microservice.user.dto.UserRegistrationRecord;
import com.microservice.user.entities.UserMS;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class KeyCloakUserServiceImpl implements KeyCloakUserService{

    private Keycloak keycloak;
    @Autowired
    private UserRepository userRepository;

    public KeyCloakUserServiceImpl(Keycloak keycloak) {
        this.keycloak = keycloak;
    }

    @Override
    public UserRegistrationRecord createUser(UserRegistrationRecord userRegistrationRecord) {
        UserRepresentation user = new UserRepresentation();
        UserMS newUser = new UserMS();

        newUser.setFirstName(userRegistrationRecord.firstName());
        newUser.setLastName(userRegistrationRecord.lastName());
        newUser.setPassword(userRegistrationRecord.password());
        newUser.setRole("user");

        user.setEnabled(true);
        user.setUsername(userRegistrationRecord.username());
        user.setEmail(userRegistrationRecord.email());
        user.setFirstName(userRegistrationRecord.firstName());
        user.setLastName(userRegistrationRecord.lastName());
        user.setEmailVerified(true);
        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setValue(userRegistrationRecord.password());
        credentialRepresentation.setTemporary(false);
        credentialRepresentation.setType(credentialRepresentation.PASSWORD);
        List<CredentialRepresentation> list = new ArrayList<>();
        list.add(credentialRepresentation);
        user.setCredentials(list);
        UsersResource usersResource = getUsersResource();
        Response response = usersResource.create(user);
        if(Objects.equals(201,response.getStatus())){
            userRepository.save(newUser);
            return userRegistrationRecord;
        }

        return null;
    }

    private UsersResource getUsersResource() {
        RealmResource realm1 = keycloak.realm("test");
        return realm1.users();
    }

    @Override
    public UserRepresentation getUserById(String userId) {
        return getUsersResource().get(userId).toRepresentation();
    }

    @Override
    public void deleteUserById(String userId) {
        getUsersResource().delete(userId);
    }
}
