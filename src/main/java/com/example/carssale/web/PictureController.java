package com.example.carssale.web;

import com.example.carssale.model.binding.PictureUploadBindingModel;
import com.example.carssale.service.CloudinaryService;
import com.example.carssale.service.Impl.CarsSaleUser;
import com.example.carssale.service.OfferService;
import com.example.carssale.service.PictureService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
@RequestMapping("/users/picture")
public class PictureController {

    private final CloudinaryService cloudinaryService;
    private final PictureService pictureService;
    private final OfferService offerService;

    public PictureController(CloudinaryService cloudinaryService, PictureService pictureService, OfferService offerService) {
        this.cloudinaryService = cloudinaryService;
        this.pictureService = pictureService;
        this.offerService = offerService;
    }

    @PostMapping("/add/{id}")
    public String uploadPicture(@Valid PictureUploadBindingModel pictureUploadBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, @AuthenticationPrincipal CarsSaleUser principal, @PathVariable String id) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("pictureUploadBindingModel",pictureUploadBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.createOfferBindingModel", bindingResult);

            return "redirect:/users/offers/edit/"+id;
        }


        return "redirect:/users/offers/edit/"+id;
    }

    @Transactional
    @GetMapping("/delete/{id}/{publicId}")
    public String deletePictureByPublicId(@PathVariable String publicId, @PathVariable String id) {
        if(cloudinaryService.delete(publicId)) {
            offerService.deleteFromOfferPicture(Long.parseLong(id),publicId);
        pictureService.deleteByPicturePublicId(publicId);
        }

        return "redirect:/users/offers/edit/"+id;
    }
}
