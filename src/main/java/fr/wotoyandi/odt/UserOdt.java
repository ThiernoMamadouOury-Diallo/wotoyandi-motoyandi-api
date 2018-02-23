package fr.wotoyandi.odt;

import lombok.*;
import java.io.Serializable;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Builder
public class UserOdt implements Serializable{

    private static final long serialVersionUID = 1L;

    private int userId;
    private String gender;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String passwordConfirm;
    private String addressLine1;
    private String addressLine2;
    private String zipCode;
    private String city;
    private String phoneNumber;
    private Date birthdate;
    private String birthdateString;
    private Date signUpDate;
}
