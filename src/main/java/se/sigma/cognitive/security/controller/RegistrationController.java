package se.sigma.cognitive.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.sigma.cognitive.security.dto.UserDto;
import se.sigma.cognitive.security.exception.UserAlreadyExistException;
import se.sigma.cognitive.security.model.User;
import se.sigma.cognitive.security.service.NotificationService;
import se.sigma.cognitive.security.service.UserService;
import se.sigma.cognitive.security.util.EmailConfigration;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@Controller
public class RegistrationController {


    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private EmailConfigration emailConfigration;


    @ModelAttribute("user")
    public UserDto userDto() {
        return new UserDto();
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {

        return "registration";
    }


    //Registration
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerNewUser(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result) throws UserAlreadyExistException {

        User exist = userService.findUserByEmail(userDto.getEmail());

        if (exist != null) {
            result.rejectValue("email", null, "There is an account already registered with this email address: ");
            throw new UserAlreadyExistException("There is an account already registered with this email address:  " + userDto.getEmail());
        }

        if (result.hasErrors()) {
            return "registration";
        }


        userDto.setCreatedBy("sigma.super@gmail.com"); //TODO create a method to get the super user E-mail

        exist = userService.registerNewUser(userDto);

        emailConfigration.setSubject("Registration confirmation");
        emailConfigration.setTo(userDto.getEmail());
        emailConfigration.setFrom("registration@sigma.se");
        emailConfigration.setContent("Welcome to Cognitive application!");
        emailSender(userDto);

        return "redirect:/registration?success";


    }

    private void emailSender(UserDto userDto) {

        Map model = new HashMap();
        model.put("name", userDto.getFirstName());
        model.put("lastName", userDto.getLastName());
        model.put("content", emailConfigration.getContent());
        emailConfigration.setModel(model);
        notificationService.sendNotification(emailConfigration);
    }






}
