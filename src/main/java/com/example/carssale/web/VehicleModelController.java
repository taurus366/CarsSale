package com.example.carssale.web;

import com.example.carssale.model.dto.ModelDTO;
import com.example.carssale.service.VehicleModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class VehicleModelController {

    private final VehicleModelService vehicleModelService;

    public VehicleModelController(VehicleModelService vehicleModelService) {
        this.vehicleModelService = vehicleModelService;
    }

    @GetMapping("/model/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<ModelDTO>> getModelByBrandId(@PathVariable String id) {
        List<ModelDTO> vehicleModelByBrandId = vehicleModelService.getVehicleModelByBrandId(Long.parseLong(id));

        return ResponseEntity.ok(vehicleModelByBrandId);
    }
}
