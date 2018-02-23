package fr.wotoyandi.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Cacheable(false)
@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter @Setter
@Builder
public class User implements Serializable{
    private static final long serialVersionUID = 1L;

    /** The identifier of the user. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int userId;

    /** The user gender. */
    @Column(name = "gender")
    private String gender;

    /** The user first name. */
    @Column(name = "first_name")
    private String firstName;

    /** The user last name. */
    @Column(name = "last_name")
    private String lastName;

    /** The user last name */
    @Column(name = "email")
    private String email;

    /** The user password. */
    @Column(name = "password")
    private String password;

    /** The user password confirmation. Only used for password confirmation on password change. */
    @Transient
    private String passwordConfirm;

    /** The user main address line. */
    @Column(name = "address_line_1")
    private String addressLine1;

    /** The user complementary address line. */
    @Column(name = "address_line_2")
    private String addressLine2;

    /** The user zip code. */
    @Column(name = "zip_code")
    private String zipCode;

    /** The user city. */
    @Column(name = "city")
    private String city;

    /** The user phone number. */
    @Column(name = "phone_number")
    private String phoneNumber;

    /** The user birth date. */
    @Column(name = "birthdate")
    private Date birthdate;

    /** The user birth date in string format. Only used to get input from JSP form. */
    @Transient
    private String birthdateString;

    /** The sign up date of the client. */
    @Column(name = "signup_date")
    private Date signUpDate;

    public User() {

    }
}
