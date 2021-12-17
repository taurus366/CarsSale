package com.example.carssale.web;

import com.example.carssale.event.OfferViewCountEvent;
import com.example.carssale.exception.OfferNotFoundException;
import com.example.carssale.messages.Messages;
import com.example.carssale.model.binding.CreateOfferBindingModel;
import com.example.carssale.model.binding.OfferEditBindingModel;
import com.example.carssale.model.dto.OfferDTO;
import com.example.carssale.model.service.CreateOfferServiceModel;
import com.example.carssale.model.service.OfferEditServiceModel;
import com.example.carssale.service.Impl.CarsSaleUser;
import com.example.carssale.service.OfferService;
import com.example.carssale.service.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users/offers")
public class OfferController {

    private final OfferService offerService;
    private final UserService userService;
    private final ApplicationEventPublisher applicationEventPublisher;

    public OfferController(OfferService offerService, UserService userService, ApplicationEventPublisher applicationEventPublisher) {
        this.offerService = offerService;
        this.userService = userService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/all")
    public String getAllOffer(Model model) {

        List<OfferDTO> allOffers = offerService.getAllOffers();

        model
                .addAttribute("offers", allOffers);

        return "vehicles-catalog";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public String getOfferByID(@PathVariable String id, Model model, @AuthenticationPrincipal CarsSaleUser principal) {

        try {
            boolean isOwnerTheOffer = offerService.isOwnerTheOffer(Long.parseLong(id), principal.getUserIdentifierEmail());
            OfferDTO offerById = offerService.getOfferById(Long.parseLong(id));
            offerById.setCanDelete(isOwnerTheOffer);
            model
                    .addAttribute("offer",offerById);
//                    .addAttribute("isOwnerTheOffer", isOwnerTheOffer);
        } catch (EntityNotFoundException e) {
            throw new OfferNotFoundException(Long.parseLong(id), Messages.OFFER_NOT_FOUND);
        }

        OfferViewCountEvent event = new OfferViewCountEvent(Long.parseLong(id));
        applicationEventPublisher.publishEvent(event);

        return "vehicle-info";
    }


    @PreAuthorize("isOwner(#id)")
    @GetMapping("/edit/{id}")
    public String editOfferById(@PathVariable String id, Model model) {
//       boolean isOwnerTheOffer = offerService.isOwnerTheOffer(Long.parseLong(id), principal.getUserIdentifierEmail());


//        if (isOwnerTheOffer) {
            model
                    .addAttribute("offer",offerService.getOfferById(Long.parseLong(id)));

            return "vehicle-edit-info";
//        }
//        return "redirect:/users/offers/all";
    }

    @PreAuthorize("isOwner(#id)")
   // @PreAuthorize("@offerServiceImpl.isOwnerTheOffer(#id,#principal.username)")
    @DeleteMapping("/delete/{id}")
    public String deleteOfferById(@PathVariable String id) {
        offerService.deleteOfferById(Long.parseLong(id));

        return "redirect:/users/offers/all";
    }

    @PreAuthorize("isOwner(#id)")
    @PatchMapping("/edit/{id}")
    public String changeInfoOffer(@PathVariable String id, @Valid OfferEditBindingModel offerEditBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
// redirectAttributes
//                    .addFlashAttribute("createOfferBindingModel", createOfferBindingModel)
//                    .addFlashAttribute("org.springframework.validation.BindingResult.createOfferBindingModel", bindingResult);

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("offerEditBindingModel", offerEditBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerEditBindingModel", bindingResult);

            return "redirect:/users/offers/edit/"+id;
        }

        //TODO
        OfferEditServiceModel offerEditServiceModel = offerService.changeOffer(offerEditBindingModel, Long.parseLong(id));

        return "redirect:/users/offers/"+id;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/add")
    public String showOfferPage(Model model) {

        return "create-offer";
    }

    @ModelAttribute
    public CreateOfferBindingModel createOfferBindingModel() {
        return new CreateOfferBindingModel();
    }

    @PreAuthorize("isAuthenticated()")
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

        List<MultipartFile> pictures =  createOfferBindingModel
                .getPicture()
                .stream()
                .filter(picture -> !picture.isEmpty())
                .collect(Collectors.toList());


        if (pictures.size() == 0) {
            bindingResult.rejectValue("picture","picture.picture");
        }

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
