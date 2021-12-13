package com.example.carssale.web;

import com.example.carssale.service.Impl.CarsSaleUser;
import com.example.carssale.service.OfferService;
import com.example.carssale.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdministratorController {

    private final UserService userService;
    private final OfferService offerService;

    public AdministratorController(UserService userService, OfferService offerService) {
        this.userService = userService;
        this.offerService = offerService;
    }

    @PreAuthorize("isAdmin()")
//    @PreAuthorize("@userServiceImpl.isAdmin(#principal.username)")
    @DeleteMapping("/delete/{id}")
    public String deletePictureById(@PathVariable String id) {
// @AuthenticationPrincipal CarsSaleUser principal   -> I don't use it because of @PreAuthorize("isAdmin()") !!!

//        boolean admin = userService.isAdmin(principal.getUserIdentifierEmail());
//        if (admin) {
            offerService.deleteOfferById(Long.parseLong(id));

//        }
        return "redirect:/users/offers/all";
    }
}
