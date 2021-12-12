package com.example.carssale.web;

import com.example.carssale.service.Impl.CarsSaleUser;
import com.example.carssale.service.OfferService;
import com.example.carssale.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
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

//    @PreAuthorize("isOwner(#id)")
    @PreAuthorize("@userServiceImpl.isAdmin(#principal.username)")
    @GetMapping("/delete/{id}")
    //TODO - from GetMapping to DeleteMapping !
    public String deletePictureById(@PathVariable String id, @AuthenticationPrincipal CarsSaleUser principal) {

//        boolean admin = userService.isAdmin(principal.getUserIdentifierEmail());
//        if (admin) {
            offerService.deleteOfferById(Long.parseLong(id));

//        }
        return "redirect:/users/offers/all";
    }
}
