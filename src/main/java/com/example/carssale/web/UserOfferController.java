package com.example.carssale.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users/offer")
public class UserOfferController {

    @GetMapping("/add")
    public String showOfferPage(Model model) {

//        model
//                .addAttribute("")

        return "create-offer";
    }
}
