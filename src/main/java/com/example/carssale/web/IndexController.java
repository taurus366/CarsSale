package com.example.carssale.web;

import com.example.carssale.service.Impl.CarsSaleUser;
import com.example.carssale.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String showIndexPage(@AuthenticationPrincipal CarsSaleUser principal, Model model) {

       try {

           model
                   .addAttribute("username", userService.getUsernameByEmail(principal.getUserIdentifierEmail()).getFirstName());
           return "index";
       }catch (Exception e) {
            return "index-guests";
       }
    }
}
