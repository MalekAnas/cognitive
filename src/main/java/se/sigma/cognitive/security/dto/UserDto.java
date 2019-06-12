package se.sigma.cognitive.security.dto;


import lombok.Data;
import se.sigma.cognitive.security.validation.PasswordMatches;
import se.sigma.cognitive.security.validation.ValidEmail;
import se.sigma.cognitive.security.validation.ValidPassword;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@PasswordMatches
public class UserDto {




    private Long id;

    @NotNull
    @Size(min = 1, message = "{message.firstName}")
    private String firstName;

    @NotNull
    @Size(min = 1, message = "{message.lastName}")
    private String lastName;

    private String userNickName;

    @NotNull
    @ValidEmail
    @Size(min = 1, message = "{message.email}")
    private String email;

    @NotNull
    @ValidEmail
    private String confirmEmail;

    @NotNull
    @ValidPassword
    @Size(min = 1, message = "{message.password}")
    private String password;

    @NotNull
    private String confirmPassword;


    @AssertTrue
    private boolean termsAccepted;




    private String createdBy;


}
