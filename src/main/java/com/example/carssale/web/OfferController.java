package com.example.carssale.web;

import com.example.carssale.model.dto.OfferDTO;
import com.example.carssale.service.OfferService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/all")
    public String getAllOffer(Model model) {

        List<OfferDTO> allOffers = offerService.getAllOffers();

        model
                .addAttribute("offers", allOffers);

        return "vehicles-catalog";
    }

    @GetMapping("/{id}")
    public String getOfferByID(@PathVariable String id, Model model) {
        model
                .addAttribute("offer",offerService.getOfferById(Long.parseLong(id)));

        return "vehicle-info";
    }

//    @GetMapping("/all")
//    public ResponseEntity<List<OfferDTO>> getALlOffers() {
//
//        return ResponseEntity.ok(offerService.getAllOffers());
//    }


}
