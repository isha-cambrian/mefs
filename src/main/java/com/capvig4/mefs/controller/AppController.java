package com.capvig4.mefs.controller;

import com.capvig4.mefs.domain.Interaction;
import com.capvig4.mefs.domain.User;
import com.capvig4.mefs.repository.UserRepository;
import com.capvig4.mefs.service.InteractionService;
import com.capvig4.mefs.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    UserRepository userRepo;
    @Autowired
    ManagerService managerService;

    @Autowired
    InteractionService interactionService;
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        System.out.println("hello");
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "register_success";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @PostMapping("/addSubordinate")
    public String addSubordinate(User manager, User subordinate) {
        managerService.addSubordinate(manager, subordinate);
        return "index";
    }

    @GetMapping("/getSubordinates")
    public String getSubordinates(User manager) {
        List<User> listUsers = userRepo.getSubordinates(manager.getId());
        return "subordinates";
    }

    @GetMapping("/portal")
    public String getInteractions(User user) {
        List<Interaction> listInteractions = interactionService.getInteractions(user);
        return "interactions";
    }
}