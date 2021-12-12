package com.example.carssale.web;

import com.example.carssale.model.binding.UserRegistrationBindingModel;
import com.example.carssale.model.service.UserRegistrationServiceModel;
import com.example.carssale.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserRegistrationController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @ModelAttribute("userModel")
    public UserRegistrationBindingModel userRegistrationBindingModel() {
        return new UserRegistrationBindingModel();
    }

    @GetMapping("/register")
    public String registerUser() {
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid UserRegistrationBindingModel userModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        boolean isSame = !userModel.getPassword().equals(userModel.getConfirmPassword());
        boolean isEmailExists = userService.isEmailExists(userModel.getEmail());

        if (bindingResult.hasErrors() || !userModel.getPassword().equals(userModel.getConfirmPassword()) || isEmailExists) {
            redirectAttributes
                    .addFlashAttribute("userModel", userModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult)
                    .addFlashAttribute("isSame",isSame)
                    .addFlashAttribute("isExistsEmail", isEmailExists);

            return "redirect:/users/register";
        }

//        System.out.println("|"+" "+userModel.getCityVillage() + " " + "|"+ " " +userModel.getRegion() +" "+"|"+ " " +userModel.getEmail());

        UserRegistrationServiceModel serviceModel = modelMapper.map(userModel, UserRegistrationServiceModel.class);

        userService.registerAndLoginUser(serviceModel);

        return "redirect:/";

    }
}
