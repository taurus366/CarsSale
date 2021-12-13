package com.example.carssale.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserLoginController {





    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    public String login() {
        return "login";
    }

    @PostMapping("/login-error")
    public String failedLogin(@ModelAttribute("email") String email
            ,RedirectAttributes redirectAttributes) {
        System.out.println("failed LOGINNNNNNNNNNNNNNNNNNNNNNNN" + email);
        redirectAttributes
                .addFlashAttribute("invalid_login",true)
                .addFlashAttribute("email",email);

        return "redirect:/users/login";
    }


}
