package com.example.carssale.web;

import com.example.carssale.model.dto.BrandDTO;
import com.example.carssale.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class VehicleBrandController {
    private final BrandService brandService;

    public VehicleBrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brand/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<BrandDTO>> getBrandByCategory(@PathVariable String id) {

        return ResponseEntity.ok(brandService.getBrandByCategoryId(Long.parseLong(id)));
    }
}
