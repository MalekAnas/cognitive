package se.sigma.cognitive.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.sigma.cognitive.security.dto.UserDto;
import se.sigma.cognitive.security.exception.UserAlreadyExistException;
import se.sigma.cognitive.security.model.User;
import se.sigma.cognitive.security.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user/partner")
public class PartnerController {



    @Autowired
    private UserService userService;


    @ModelAttribute("user")
    public UserDto userDto() {
        return new UserDto();
    }





    private String getCurrentUserEmail() {


        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        String userName = userDetails.getUsername();


        return userName;
    }



    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public String showPartnerDashBoard(){
        return "partner_dashboard";
    }


    @RequestMapping(value = "/add_admin", method = RequestMethod.GET)
    public String showAddAdmin(Model model) {


        model.addAttribute("parentEmail", getCurrentUserEmail());
        model.addAttribute("createdByParent", getCurrentUserEmail());
        return "partner_add_admin";
    }

    @RequestMapping(value = "/add_admin", method = RequestMethod.POST)
    public String addNewAdmin(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result) throws UserAlreadyExistException {
        User existingUser = userService.findUserByEmail(userDto.getEmail());
        if (existingUser != null) {
            result.rejectValue("email", null, "There is an account already registered with this email address:");
            throw new UserAlreadyExistException("There is an account already registered with this email address:" + userDto.getEmail());
        }

        if (result.hasErrors()) {
            return "add_admin";
        }

        userDto.setCreatedBy(getCurrentUserEmail());

        userService.registerNewAdmin(userDto);
        return "redirect:/user/partner/add_admin?success";
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



}
