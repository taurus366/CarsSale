package com.example.carssale.web;

import com.example.carssale.model.dto.RegionDTO;
import com.example.carssale.service.RegionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class RegionController {

    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/region")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<RegionDTO>> getAllRegions() {
        List<RegionDTO> allRegions = regionService.getAllRegions();

        return ResponseEntity
                .ok(allRegions);
    }
}
