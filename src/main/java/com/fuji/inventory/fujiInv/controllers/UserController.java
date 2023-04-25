package com.fuji.inventory.fujiInv.controllers;

import com.fuji.inventory.fujiInv.models.User;
import com.fuji.inventory.fujiInv.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user-add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String users(@RequestParam(name = "usersModel", required = false) String usersModel,
                        Model model
    ) {

        model.addAttribute("users", userService.usersModel(usersModel));
        model.addAttribute("currentUserEmail", currentUserMail());
        return ("/add-user");
    }

    @GetMapping("/user/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String userInfo(@PathVariable String username, Model model) {
        User userInfo = userService.getUserByUserName(username);
        model.addAttribute("userInfo", userInfo);
        return "user-info";
    }

    @PostMapping("/users/{username}/update")
    public String updateUser(@PathVariable String username, User user){
        User userDB = userService.updateUser(username);
        userDB.setActive(user.isActive());
        userDB.setPassword(user.getPassword());
        userDB.setRoles(user.getRoles());
        userDB.setDepartment(user.getDepartment());
        userDB.setPermissions(user.getPermissions());
        userService.createUser(userDB);
        return "redirect:/users";
    }

    @PostMapping("/users/create")
//    @PreAuthorize("hasRole('ADMIN')")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("userAddError", "User with same data " + user + " already exists!");
            return "redirect:/user-add";
        }
        userService.createUser(user);
        model.addAttribute("user_added", "New User added successfully!");
        return "redirect:/user-add";
    }

    @PostMapping("/users/delete/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/user-add";
    }

    @GetMapping("/access-dennied")
    public String accessDennied() {
        return "accessDennie";
    }

    public String currentUserMail() {
        return "@eu.fujikura.com";
    }
}
