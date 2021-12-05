package com.example.carssale.web;

import com.example.carssale.model.dto.CityVillageDTO;
import com.example.carssale.model.dto.RegionDTO;
import com.example.carssale.service.CityVillageService;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class CityVillageController {

    private final CityVillageService cityVillageService;
    private final Gson gson;

    public CityVillageController(CityVillageService cityVillageService, Gson gson) {
        this.cityVillageService = cityVillageService;
        this.gson = gson;
    }

    @GetMapping("/cityVillage/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<CityVillageDTO>> getCityVillageById(@PathVariable String id) {

        List<CityVillageDTO> cityVillageByRegionId = cityVillageService.getCityVillageById(Long.parseLong(id));

        return ResponseEntity
                .ok(cityVillageByRegionId);
    }
}
