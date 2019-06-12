package se.sigma.cognitive.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se.sigma.cognitive.security.dto.UserDto;
import se.sigma.cognitive.security.exception.UserAlreadyExistException;
import se.sigma.cognitive.security.model.*;
import se.sigma.cognitive.security.repository.PasswordResetTokenRepository;
import se.sigma.cognitive.security.repository.RoleRepository;
import se.sigma.cognitive.security.repository.UserRepository;
import se.sigma.cognitive.security.repository.VerificationTokenRepository;
import se.sigma.cognitive.security.util.EmailConfigration;

import javax.persistence.OneToMany;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {


    //Fields
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailConfigration emailConfigration;
    //CONST
    public static final String TOKEN_INVALID = "invalidToken";
    public static final String TOKEN_EXPIRED = "expired";
    public static final String TOKEN_VALID = "valid";


    @Override
    public User registerNewUser(UserDto userDto) throws UserAlreadyExistException {
        if (emailIsExist(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account already registered with this email address:" + userDto.getEmail());
        }


        User newUser = new User();

        //encoded password
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());


        newUser.setFirstName(userDto.getFirstName());
        newUser.setLastName(userDto.getLastName());
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(encodedPassword);
        newUser.setCreatedBy(userDto.getCreatedBy());
        newUser.setRoles(Arrays.asList(
                new Role("ROLE_USER"))
        );


        return userRepository.save(newUser);
    }

    @Override
    public User registerNewPartner(UserDto userDto) throws UserAlreadyExistException {//, Parent parent) throws UserAlreadyExistException {
        if (emailIsExist(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account already registered with this email address:" + userDto.getEmail());
        }


        User newPartner = new User();


        //b-crypting the password
        String cryptedPassword = passwordEncoder.encode(userDto.getPassword());


        newPartner.setFirstName(userDto.getFirstName());
        newPartner.setLastName(userDto.getLastName());
        newPartner.setEmail(userDto.getEmail());
        newPartner.setPassword(cryptedPassword);
        newPartner.setCreatedBy(userDto.getCreatedBy());
        newPartner.setRoles(Arrays.asList(
                new Role("ROLE_PARTNER")
               ));

        User parent = userRepository.findByEmail(userDto.getCreatedBy());

        List<User> partners = parent.getPartners();
        partners.add(newPartner);


        return userRepository.save(newPartner);
    }

    @Override
    public User addNewUser(UserDto userDto) throws UserAlreadyExistException {//, Parent parent) throws UserAlreadyExistException {
        if (emailIsExist(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account already registered with this email address:" + userDto.getEmail());
        }


        User newUser = new User();


        //b-crypting the password
        String cryptedPassword = passwordEncoder.encode(userDto.getPassword());


        newUser.setFirstName(userDto.getFirstName());
        newUser.setLastName(userDto.getLastName());
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(cryptedPassword);
        newUser.setCreatedBy(userDto.getCreatedBy());
        newUser.setRoles(Arrays.asList(
                new Role("ROLE_USER")
        ));

        User parent = userRepository.findByEmail(userDto.getCreatedBy());

        List<User> users = parent.getUsers();
        users.add(newUser);


        return userRepository.save(newUser);
    }

    @Override
    public User registerNewAdmin(UserDto userDto) throws UserAlreadyExistException {
        if (emailIsExist(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account already registered with this email address:" + userDto.getEmail());
        }


        User newAdmin = new User();

        //b-crypting the password
        String cryptedPassword = passwordEncoder.encode(userDto.getPassword());


        newAdmin.setFirstName(userDto.getFirstName());
        newAdmin.setLastName(userDto.getLastName());
        newAdmin.setEmail(userDto.getEmail());
        newAdmin.setPassword(cryptedPassword);
        newAdmin.setCreatedBy(userDto.getCreatedBy());
        newAdmin.setRoles(Arrays.asList(new Role("ROLE_ADMIN")
                , new Role("ROLE_USER")
        ));

        User parent = userRepository.findByEmail(userDto.getCreatedBy());
        parent.getAdmins().add(newAdmin);

        return userRepository.save(newAdmin);
    }


    //Checks if an email is exist in DB records
    private boolean emailIsExist(String email) {
        User existUser = userRepository.findByEmail(email);
        boolean isExist = false;
        if (existUser != null)
            isExist = true;
        return isExist;
    }


    @Override
    public User findUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }

    @Override
    public void changeUserPassword(User user, String newPassword) {

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Override
    public void changeUserUserName(User user, String newUserName) {

        user.setUserNickName(newUserName);
        userRepository.save(user);
    }

    @Override
    public void save(User user) {

        userRepository.save(user);
    }

    @Override
    public void delete(User user) {

        //delete verification token for this user
        final VerificationToken vToken = verificationTokenRepository.findByUser(user);
        verificationTokenRepository.delete(vToken);

        //delete pass reset token for this user
        final PasswordResetToken pToken = passwordResetTokenRepository.findByUser(user);
        passwordResetTokenRepository.delete(pToken);

        //delete the user!
        userRepository.delete(user);
    }

    @Override
    public User getUser(final String verificationToken) {

        final VerificationToken vToken = verificationTokenRepository.findByToken(verificationToken);
        if (vToken != null)
            return vToken.getUser();

        return null;
    }


    @Override
    public PasswordResetToken getPasswordResetToken(final String token) {
        return passwordResetTokenRepository.findByToken(token);
    }


    @Override
    public VerificationToken generateNewVerificationToken(String existingVToken) {
        final VerificationToken vToken = verificationTokenRepository.findByToken(existingVToken);

        vToken.updateToken(UUID.randomUUID().toString());
        verificationTokenRepository.save(vToken);
        return vToken;
    }

    @Override
    public void createPasswordResetTokenForUser(User user, String token) {
        final PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordResetTokenRepository.save(myToken);
    }

    @Override
    public void createVerificationTokenForUser(final User user, final String token) {
        final VerificationToken myToken = new VerificationToken(token, user);
        verificationTokenRepository.save(myToken);
    }

    @Override
    public boolean checkIfValidOldPassword(final User user, final String oldPassword) {
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }


    @Override
    public String validateVerificationToken(String token) {
        final VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        if (verificationToken == null)
            return TOKEN_INVALID;

        final User user = verificationToken.getUser();
        final Calendar calendar = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - calendar.getTime().getTime()) <= 0) {
            verificationTokenRepository.delete(verificationToken);
            return TOKEN_EXPIRED;
        }

        user.setEnabled(true);
        return TOKEN_VALID;

    }

    @Override
    public User getUserByPasswordResetToken(final String token) {

        return passwordResetTokenRepository.findByToken(token).getUser();
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }


    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getChilds(String parentEmail) {


        return userRepository.findAllByCreatedBy(parentEmail);

    }

    @Override
    public List<User> getPartners(User parent) {
        return parent.getPartners();
    }

    @Override
    public List<User> getAdmins(User parent) {
        return parent.getPartners();
    }

    @Override
    public List<Long> getRolesIdsByUserId(Long userId) {
        return roleRepository.getRoleIdsByUserId(userId);
    }

    @Override
    public List<String> getRolesNameByUserId(Long userId) {
        List<Long> rolesIds = getRolesIdsByUserId(userId);
        List<String> rolesNames = new ArrayList<>();
        for (Long id : rolesIds) {

            String name = roleRepository.getRoleNameById(id);
            rolesNames.add(name);
            return rolesNames;
        }


        return null;
    }
}
