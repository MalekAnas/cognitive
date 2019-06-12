package se.sigma.cognitive.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import se.sigma.cognitive.security.dto.UserDto;
import se.sigma.cognitive.security.exception.UserAlreadyExistException;
import se.sigma.cognitive.security.model.PasswordResetToken;
import se.sigma.cognitive.security.model.User;
import se.sigma.cognitive.security.model.VerificationToken;

import java.util.List;

public interface UserService extends UserDetailsService {


    List<String> getRolesNameByUserId(Long userId);

    List<User> getPartners(User parent);
    List<User> getAdmins(User parent);


    List<Long> getRolesIdsByUserId(Long userId);

    List<User> getChilds(String parentEmail);

    PasswordResetToken getPasswordResetToken(String token);



    User addNewUser(UserDto userDto) throws UserAlreadyExistException;
    User registerNewPartner(UserDto userDto) throws UserAlreadyExistException;

    User registerNewAdmin(UserDto userDto) throws UserAlreadyExistException;

    User findUserByEmail(String userEmail);

    User getUser(String verificationToken);

    User registerNewUser(UserDto userDto) throws UserAlreadyExistException;

    User getUserByPasswordResetToken(String token);






    VerificationToken generateNewVerificationToken(String token);

    String validateVerificationToken(String token);






    void changeUserPassword(User user, String newPassword);

    void changeUserUserName(User user, String newUserName);

    void save(User user);

    void delete(User user);

    void createPasswordResetTokenForUser(User user, String token);

    void createVerificationTokenForUser(User user, String token);

    boolean checkIfValidOldPassword(User user, String password);


}
