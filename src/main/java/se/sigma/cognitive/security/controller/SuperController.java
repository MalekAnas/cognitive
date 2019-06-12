package se.sigma.cognitive.security.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import se.sigma.cognitive.security.dto.UserDto;
import se.sigma.cognitive.security.exception.UserAlreadyExistException;
import se.sigma.cognitive.security.model.User;
import se.sigma.cognitive.security.repository.UserRepository;
import se.sigma.cognitive.security.service.NotificationService;
import se.sigma.cognitive.security.service.UserService;
import se.sigma.cognitive.security.util.DefaultPasswordGenerator;
import se.sigma.cognitive.security.util.EmailConfigration;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user/super")
@Slf4j
public class SuperController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DefaultPasswordGenerator passwordGenerator;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private EmailConfigration emailConfigration;


    @ModelAttribute("user")
    public UserDto userDto() {
        return new UserDto();
    }


    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public String showSuperDashBoard(Model model) {

        return "super_dashboard";
    }


    @RequestMapping(value = "/add_partner", method = RequestMethod.GET)
    public String showAddPartner(Model model) {


        model.addAttribute("parentEmail", getCurrentUserEmail());
        model.addAttribute("createdByParent", getCurrentUserEmail());
        return "add_partner";
    }

    @RequestMapping(value = "/add_partner", method = RequestMethod.POST)
    public String addNewPartner(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result) throws UserAlreadyExistException {

        User existingUser = userService.findUserByEmail(userDto.getEmail());
        if (existingUser != null) {
            result.rejectValue("email", null, "There is an account already registered with this email address:");
            throw new UserAlreadyExistException("There is an account already registered with this email address:" + userDto.getEmail());
        }

        if (result.hasErrors()) {
            return "add_partner";
        }


        userDto.setCreatedBy(getCurrentUserEmail());
        userService.registerNewPartner(userDto);


        emailConfigration.setSubject("Registration confirmation");
        emailConfigration.setTo(userDto.getEmail());
        emailConfigration.setFrom("registration@sigma.se");
        emailConfigration.setContent("Welcome to Cognitive application!");
        emailSender(userDto, emailConfigration);

        return "redirect:/user/super/add_partner?success";
    }


    private String getCurrentUserEmail() {


        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        String userName = userDetails.getUsername();


        return userName;
    }


    //Shows all the users with role partner, only users with this parent super will be loaded
    @RequestMapping(value = "/view_partners", method = RequestMethod.GET)
    public String viewPartners(Model model) {

        User parent = userRepository.findByEmail(getCurrentUserEmail());

        List<User> partners = parent.getPartners();

        model.addAttribute("partners", partners);

        return "view_partners_super";
    }

    @RequestMapping(value = "/add_admin", method = RequestMethod.GET)
    public String showAddAdmin(Model model) {


        model.addAttribute("parentEmail", getCurrentUserEmail());
        model.addAttribute("createdByParent", getCurrentUserEmail());
        return "super_add_admin";
    }

    @RequestMapping(value = "/add_admin", method = RequestMethod.POST)
    public String addNewAdmin(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result) throws UserAlreadyExistException {


        log.info("THIS IS PARENT EMAIL VALUE = " + getCurrentUserEmail());


        User existingUser = userService.findUserByEmail(userDto.getEmail());
        if (existingUser != null) {
            result.rejectValue("email", null, "There is an account already registered with this email address:");
            throw new UserAlreadyExistException("There is an account already registered with this email address:" + userDto.getEmail());
        }

        if (result.hasErrors()) {
            return "super_dashboard";
        }

        userDto.setCreatedBy(getCurrentUserEmail());

        userService.registerNewAdmin(userDto);
        return "redirect:/user/super/add_admin?success";
    }


    //Shows all the users with role admin, only users with parent super will be loaded
    @RequestMapping(value = "/view_admins", method = RequestMethod.GET)
    public String viewAdmins(Model model) {

        List<User> users = userService.getChilds(getCurrentUserEmail());


        List<User> admins = new ArrayList<>();


        for (User user : users) {

            Long userId = user.getId();
            for (String roleName : userService.getRolesNameByUserId(userId)) {
                if (roleName.equals("ROLE_ADMIN"))
                    admins.add(user);


            }


        }

        model.addAttribute("admins", admins);
        return "view_admins_super";
    }


    @RequestMapping(value = "/view_admins/users/{id}", method = RequestMethod.GET)
    public String viewAdminsChildren(Model model, @PathVariable("id") Long id) {

        User admin = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id:" + id));

        List<User> users = admin.getUsers();


        model.addAttribute("users", users);


        return "users";
    }

    @RequestMapping(value = "/view_partners/admins/{id}", method = RequestMethod.GET)
    public String viewPartnersChildren(Model model, @PathVariable("id") Long id) {

        User partner = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id:" + id));

        List<User> admins = partner.getAdmins();


        model.addAttribute("admins", admins);
        return "admins";
    }



    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update_user";
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {

        User userToUpdate = userRepository.getUserById(id);

        if (result.hasErrors()) {

            userDto.setId(id);
            return "update_user";
        }
        userToUpdate.setFirstName(userDto.getFirstName());
        userToUpdate.setLastName(userDto.getLastName());
        userToUpdate.setEmail(userDto.getEmail());

        userRepository.save(userToUpdate);

        return "redirect:/user/super/edit/" + id + "?success";

    }


    @RequestMapping(value = "/delete_partner/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deletePartner(@PathVariable("id") long id, Model model) {

        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        userRepository.deleteById(id);
        return "redirect:/user/super/view_partners?success";
    }

    @RequestMapping(value = "/delete_admin/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteAdmin(@PathVariable("id") long id, Model model) {

        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        userRepository.deleteById(id);
        return "redirect:/user/super/view_admins?success";
    }


    private void emailSender(UserDto userDto, EmailConfigration emailConfigration) {

        Map model = new HashMap();
        model.put("name", userDto.getFirstName());
        model.put("lastName", userDto.getLastName());
        model.put("content", emailConfigration.getContent());
        emailConfigration.setModel(model);
        notificationService.sendNotification(emailConfigration);
    }




    @RequestMapping(value = "/delete_user/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteUser(@PathVariable("id") long id, Model model) {

        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        userRepository.deleteById(id);
        return "redirect:/user/super/view_admins?success";
    }






}


