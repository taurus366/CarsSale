package com.example.carssale.web;

import com.example.carssale.model.dto.VehicleCategoryDTO;
import com.example.carssale.service.VehicleCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class VehicleCategoryController {

    private final VehicleCategoryService vehicleCategoryService;

    public VehicleCategoryController(VehicleCategoryService vehicleCategoryService) {
        this.vehicleCategoryService = vehicleCategoryService;
    }

    @GetMapping("/category")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<VehicleCategoryDTO>> getAllCategories() {

        return ResponseEntity
                .ok(vehicleCategoryService.getAllVehicleCategories());
    }
}
