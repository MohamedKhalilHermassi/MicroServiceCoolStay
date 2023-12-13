package com.microservice.user.Service;

import com.microservice.user.Repositories.UserRepository;
import com.microservice.user.client.ReclamationClient;
import com.microservice.user.client.ReservationClient;
import com.microservice.user.dto.UserRegistrationRecord;
import com.microservice.user.entities.FullUserResponse;
import com.microservice.user.entities.FullUserWithReclamationResponse;
import com.microservice.user.entities.UserMS;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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
    @Autowired
    private ReservationClient reservationClient;
    @Autowired
    private ReclamationClient reclamationClient;

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
        newUser.setEmail(userRegistrationRecord.email());

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
        RealmResource realm1 = keycloak.realm("SpringbootKeycloak");
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

    public FullUserResponse findUsersWithReservations(Long userId) {
        var user = userRepository.findById(userId)
                .orElse(UserMS.builder()
                        .role("NOT_FOUND")
                        .firstName("NOT_FOUND")
                        .lastName("NOT_FOUND")
                        .password("NOT_FOUND")
                        .email("NOT_FOUND")
                        .build()
                );
        var reservation = reservationClient.findAllUsersWithReservations(userId); // get all reservation from ReservationMS
        return FullUserResponse.builder()
                .id(user.getId())
                
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .reservations(reservation)
                .role(user.getRole())


                .build();
    }

    public FullUserWithReclamationResponse findUserWithReclamations(Long userId) {

        var user = userRepository.findById(userId)
                .orElse(UserMS.builder()
                        .role("NOT_FOUND")
                        .firstName("NOT_FOUND")
                        .lastName("NOT_FOUND")
                        .password("NOT_FOUND")
                        .email("NOT_FOUND")
                        .build()
                );
        var reclamation = reclamationClient.findAllUsersWithReclamations(userId); // get all reservation from ReservationMS
        return FullUserWithReclamationResponse.builder()
                .id(user.getId())

                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .reclamations(reclamation)
                .role(user.getRole())


                .build();
    }

    public UserMS FindUserByFirstName( String firstName)
    {
        return userRepository.findByFirstName(firstName);
    }
}
