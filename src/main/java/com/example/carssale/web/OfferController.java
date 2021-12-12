package com.example.carssale.web;

import com.example.carssale.exception.OfferNotFoundException;
import com.example.carssale.model.binding.CreateOfferBindingModel;
import com.example.carssale.model.dto.OfferDTO;
import com.example.carssale.model.service.CreateOfferServiceModel;
import com.example.carssale.service.Impl.CarsSaleUser;
import com.example.carssale.service.OfferService;
import com.example.carssale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users/offers")
public class OfferController {

    private final OfferService offerService;
    private final UserService userService;
    private static String OFFER_NOT_FOUND = "Cannot find Car Offer with id ";

    public OfferController(OfferService offerService, UserService userService) {
        this.offerService = offerService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getAllOffer(Model model) {

        List<OfferDTO> allOffers = offerService.getAllOffers();

        model
                .addAttribute("offers", allOffers);

        return "vehicles-catalog";
    }

    @GetMapping("/{id}")
    public String getOfferByID(@PathVariable String id, Model model, @AuthenticationPrincipal CarsSaleUser principal) {

        try {
            boolean admin = userService.isAdmin(principal.getUserIdentifierEmail());
            boolean isOwnerTheOffer = offerService.isOwnerTheOffer(Long.parseLong(id), principal.getUserIdentifierEmail());
            model
                    .addAttribute("offer",offerService.getOfferById(Long.parseLong(id)))
                    .addAttribute("isAdmin",admin)
                    .addAttribute("isOwnerTheOffer", isOwnerTheOffer);
        } catch (EntityNotFoundException e) {
            throw new OfferNotFoundException(Long.parseLong(id),OFFER_NOT_FOUND);
        }


        return "vehicle-info";
    }



    @GetMapping("/edit/{id}")
    public String editOfferById(@PathVariable String id, @AuthenticationPrincipal CarsSaleUser principal,Model model) {
       boolean isOwnerTheOffer = offerService.isOwnerTheOffer(Long.parseLong(id), principal.getUserIdentifierEmail());

        if (isOwnerTheOffer) {
            model
                    .addAttribute("offer",offerService.getOfferById(Long.parseLong(id)));

            return "vehicle-edit-info";
        }
        return "redirect:/users/offers/all";
    }

    @GetMapping("/add")
    public String showOfferPage(Model model) {

        return "create-offer";
    }

    @ModelAttribute
    public CreateOfferBindingModel createOfferBindingModel() {
        return new CreateOfferBindingModel();
    }

    @PostMapping("/add")
    public String createOffer(@Valid CreateOfferBindingModel createOfferBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, @AuthenticationPrincipal CarsSaleUser principal) {

//        System.out.printf("%s , %s , %s, %s, %s, %s, %s, %s, %s , %s , %s , %s , %s , %s , %s",createOfferBindingModel.getModel().getModelName()
//                ,createOfferBindingModel.getBrand()
//                ,createOfferBindingModel.getCarCoupe()
//                //null - fixed
//                ,createOfferBindingModel.getDoorCount()
//                //null
////                ,createOfferBindingModel.getOfferDescription()
//                //null - fixed
//                ,createOfferBindingModel.getEmissionClass()
//                //null
//                ,createOfferBindingModel.getExteriorColor()
//                ,createOfferBindingModel.getFuelType()
//                ,createOfferBindingModel.getPicture().get(0).isEmpty()
//                ,createOfferBindingModel.getKilometer()
//                ,createOfferBindingModel.getPower()
//                ,createOfferBindingModel.getPrice()
//                ,createOfferBindingModel.getPriceType()
//                ,createOfferBindingModel.getStatusUsed()
//                ,createOfferBindingModel.getVehicleStatus()
//                ,createOfferBindingModel.getVehicleYear());

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("createOfferBindingModel", createOfferBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.createOfferBindingModel", bindingResult);
            return "redirect:/users/offers/add";
        }


        System.out.println(principal.getUserIdentifierEmail());

        CreateOfferServiceModel offer = offerService.createOffer(createOfferBindingModel, principal.getUserIdentifierEmail());


        return "redirect:/";
    }





//    @GetMapping("/all")
//    public ResponseEntity<List<OfferDTO>> getALlOffers() {
//
//        return ResponseEntity.ok(offerService.getAllOffers());
//    }


}
