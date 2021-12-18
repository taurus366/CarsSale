package com.example.carssale.web;

import com.example.carssale.model.binding.UserUpdateInfoBindingModel;
import com.example.carssale.model.dto.UserDTO;
import com.example.carssale.service.Impl.CarsSaleUser;
import com.example.carssale.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserProfileController {

    private final UserService userService;

    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public String showProfile(@AuthenticationPrincipal CarsSaleUser principal , Model model) {

        UserDTO usernameByEmail = userService.getUsernameByEmail(principal.getUserIdentifierEmail());

        model
                .addAttribute("userInfo",usernameByEmail);

        return "profile";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile/edit")
    public String showEditProfile(@AuthenticationPrincipal CarsSaleUser principal , Model model) {

        UserDTO usernameByEmail = userService.getUsernameByEmail(principal.getUserIdentifierEmail());

        model
                .addAttribute("userInfo",usernameByEmail);

        return "profile-edit";
    }

    @PreAuthorize("isAuthenticated()")
    @PatchMapping("/profile/edit")
    public String updateUserProfile(@Valid UserUpdateInfoBindingModel userUpdateInfoBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, @AuthenticationPrincipal CarsSaleUser principal) {

        boolean isSamePasswords = userUpdateInfoBindingModel.getNewPassword().equals(userUpdateInfoBindingModel.getRePassword());
        boolean isOldPasswordValid = userService.checkPasswordValid(userUpdateInfoBindingModel.getOldPassword(),principal.getUserIdentifierEmail());

//        if (bindingResult.hasErrors() || !isSamePasswords || !isOldPasswordValid) {
//            redirectAttributes
//                    .addFlashAttribute("userModel", userModel)
//                    .addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult)
//                    .addFlashAttribute("isSame",isSame)
//                    .addFlashAttribute("isExistsEmail", isEmailExists);
//
//            return "redirect:/users/register";
//        }
        return null;
    }
}
