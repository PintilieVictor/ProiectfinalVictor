package com.app.projectVictor.Controlers;

import com.app.projectVictor.Services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.register(user);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        // Add logic to retrieve user profile data
        return "profile";
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
        public String getUserProfile(@PathVariable Long userId, Model model) {
            User user = userService.findUserById(userId);
            if (user != null) {
                model.addAttribute("user", user);
                return "user/profile"; // Return the profile HTML template
            } else {
                // Handle the case where the user is not found
                return "error"; // Return an error HTML template
            }
        }

        @PostMapping("/{userId}/update")
        public String updateUserProfile(@PathVariable Long userId, @ModelAttribute User updatedUser) {
            User existingUser = userService.findUserById(userId);
            if (existingUser != null) {
                // Update user properties
                existingUser.setUsername(updatedUser.getUsername());

                // Update other properties as needed

                userService.updateUser(existingUser);
            }
            return "redirect:/users/" + userId;
        }

    }

