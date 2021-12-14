package com.example.carssale.web;

import com.example.carssale.service.Impl.CarsSaleUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String showIndexPage(@AuthenticationPrincipal CarsSaleUser principal) {

       try {
           principal.getUserIdentifierEmail();
           return "index";
       }catch (Exception e) {
            return "index-guests";
       }
    }
}
