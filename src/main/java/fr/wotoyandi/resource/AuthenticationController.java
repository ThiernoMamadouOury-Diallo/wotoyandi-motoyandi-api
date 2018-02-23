package fr.wotoyandi.resource;

import fr.wotoyandi.model.User;
import fr.wotoyandi.odt.UserOdt;
import fr.wotoyandi.service.impl.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.WebApplicationException;

@RestController
@RequestMapping("/auth")
public class AuthenticationController extends AbstractController{

    private static final Logger LOG
            = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthService authService;

    @GET
    @Path("/loggin/{name}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    ///on peut utiliser aussi le Set //à revoir
    public List<UserOdt> getAllUser(@PathParam("name") String name) {
        return authService.getAllUsers(name)
                .stream()
                .map(this::userToOdt)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/users/{userId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public UserOdt getUser(@PathParam("userId") String name) {
        if (null == name){
            String error = "error";
            LOG.info("");
            throw new WebApplicationException(error, Response.Status.BAD_REQUEST);
        }else {

            //Test de retour d'un odt
            User user = new User();
            return userToOdt(user);
        }
    }

    @GET
    @Path("/users/detail/{userId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public UserOdt getUserDetail(@PathParam("userId") String name) {
        User user = new User();
        return (user != null)
                ? userToOdt(user)
                :null;
    }

    private UserOdt userToOdt(User user){
        return user != null ? UserOdt.builder()
                .userId(user.getUserId())
                .gender(user.getGender())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .passwordConfirm(user.getPasswordConfirm())
                .addressLine1(user.getAddressLine1())
                .addressLine2(user.getAddressLine2())
                .zipCode(user.getZipCode())
                .city(user.getCity())
                .phoneNumber(user.getPhoneNumber())
                .birthdate(user.getBirthdate())
                .signUpDate(user.getSignUpDate())

                .build() : null;
    }
}
