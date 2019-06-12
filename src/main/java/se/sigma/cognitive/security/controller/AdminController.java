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
@RequestMapping("/user/admin")
public class AdminController {


    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public String showAdminDashBoard(){
        return "admin_dashboard";
    }

    @ModelAttribute("user")
    public UserDto userDto() {
        return new UserDto();
    }


    private String getCurrentUserEmail() {


        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        String userName = userDetails.getUsername();


        return userName;
    }





    @RequestMapping(value = "/add_user", method = RequestMethod.GET)
    public String showAddUser(Model model) {


        model.addAttribute("parentEmail", getCurrentUserEmail());
        return "admin_add_user";
    }

    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result) throws UserAlreadyExistException {
        User existingUser = userService.findUserByEmail(userDto.getEmail());
        if (existingUser != null) {
            result.rejectValue("email", null, "There is an account already registered with this email address:");
            throw new UserAlreadyExistException("There is an account already registered with this email address:" + userDto.getEmail());
        }

        if (result.hasErrors()) {
            return "add_user";
        }

        userDto.setCreatedBy(getCurrentUserEmail());

        userService.addNewUser(userDto);
        return "redirect:/user/admin/add_user?success";
    }


    //Shows all the users with role admin, only users with parent super will be loaded
    @RequestMapping(value = "/view_users", method = RequestMethod.GET)
    public String viewAdmins(Model model) {

        List<User> allChildren = userService.getChilds(getCurrentUserEmail());


        List<User> users = new ArrayList<>();


        for (User user : allChildren) {

            Long userId = user.getId();
            for (String roleName : userService.getRolesNameByUserId(userId)) {
                if (roleName.equals("ROLE_USER"))
                    users.add(user);


            }


        }

        model.addAttribute("users", users);
        return "view_users_super";
    }








}
