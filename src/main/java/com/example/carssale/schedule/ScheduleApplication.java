package com.example.carssale.schedule;

import com.example.carssale.service.CityVillageService;
import com.example.carssale.service.RegionService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleApplication {

    private final RegionService regionService;
    private final CityVillageService cityVillageService;

    public ScheduleApplication(RegionService regionService, CityVillageService cityVillageService) {
        this.regionService = regionService;
        this.cityVillageService = cityVillageService;
    }


    @Scheduled(fixedDelay = 3600000, initialDelay = 3600000)
    @CacheEvict(cacheNames = "city", allEntries = true)
    public void updateRegionAndCityCache() {

        regionService.getAllRegions();
        cityVillageService.getAllCities();
    }







}
