package se.sigma.cognitive.security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.sigma.cognitive.security.repository.UserRepository;
import se.sigma.cognitive.security.service.UserService;

@Controller
public class HomeController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"", "/", "/home"}, method = RequestMethod.GET)
    public String root() {
        return "welcome";
    }

    @RequestMapping(value = {"/login", "/signIn"}, method = RequestMethod.GET)
    public String showLogin() {
        return "login";
    }






}

