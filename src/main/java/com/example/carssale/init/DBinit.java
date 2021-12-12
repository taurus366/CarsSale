package com.example.carssale.init;

import com.example.carssale.model.entity.*;
import com.example.carssale.model.entity.enums.*;
import com.example.carssale.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Component
public class DBinit implements CommandLineRunner {

    private final RoleRepository roleRepository;

    private final VehicleCoupeRepository vehicleCoupeRepository;
    private final TransmissionRepository transmissionRepository;
    private final VehicleCategoryRepository vehicleCategoryRepository;
    private final FuelTypeRepository fuelTypeRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final VehicleYearRepository vehicleYearRepository;
    private final OfferRepository offerRepository;
    private final CityVillageRepository cityVillageRepository;
    private final RegionRepository regionRepository;


    public DBinit(RoleRepository roleRepository, VehicleCoupeRepository vehicleCoupeRepository, TransmissionRepository transmissionRepository, VehicleCategoryRepository vehicleCategoryRepository, FuelTypeRepository fuelTypeRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, ModelRepository modelRepository, BrandRepository brandRepository, VehicleYearRepository vehicleYearRepository, OfferRepository offerRepository, CityVillageRepository cityVillageRepository, RegionRepository regionRepository) {
        this.roleRepository = roleRepository;
        this.vehicleCoupeRepository = vehicleCoupeRepository;
        this.transmissionRepository = transmissionRepository;
        this.vehicleCategoryRepository = vehicleCategoryRepository;
        this.fuelTypeRepository = fuelTypeRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.vehicleYearRepository = vehicleYearRepository;
        this.offerRepository = offerRepository;
        this.cityVillageRepository = cityVillageRepository;
        this.regionRepository = regionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("-".repeat(50));
        initRoles();
        initUsers();

        initTransmission();
        initCarCoupeTypes();
        initFuelType();

        //TODO first init brands and models if table is empty! after that , set Model's [coupe,year,transmission,fuel] !
        initCarCategories();
        initBrands();
        initModels();

        initOffer();
    }

    private void initOffer() {
      if (offerRepository.findAll().isEmpty()) {
          OfferEntity offer = new OfferEntity();
          offer.setCreated(Instant.now());
          offer.setModified(Instant.now());

          offer.setModel(modelRepository.findAll().get(0));
          offer.setUser(userRepository.getById(Long.parseLong("1")));
          offer.setTransmission(TransmisionEnum.AUTOMATIC);
          offer.setFuelType(FuelTypeEnum.DIESEL);
          offer.setCarCoupe(VehicleCoupeEnum.COUPE);
          offer.setDoorCount(5);
          offer.setEmissionClass("EURO5");
          offer.setExteriorColor(ExteriorColorEnum.RED);
          offer.setPriceType(PriceTypeEnum.BGN);
          offer.setVehicleStatus(VehicleStatusEnum.GOOD);
          offer.setVehicleYear(2021);
          offer.setPrice(25000);


          offerRepository.save(offer);
      }
    }

    private void initModels() {
        if (modelRepository.findAll().isEmpty()) {
            BrandEntity bmw = brandRepository.findByBrandName("BMW");

            ModelEntity modelBmwX6 = new ModelEntity();
            modelBmwX6.setBrand(bmw);
            modelBmwX6.setModelName("X6");

            FuelTypeEntity gasoline = fuelTypeRepository.findByName(FuelTypeEnum.GASOLINE);
            FuelTypeEntity diesel = fuelTypeRepository.findByName(FuelTypeEnum.DIESEL);
            modelBmwX6.setFuelType(List.of(gasoline,diesel));

            VehicleCoupeEntity hatchback = vehicleCoupeRepository.findByVehicleCoupe(VehicleCoupeEnum.HATCHBACK);
            modelBmwX6.setVehicleCoupe(List.of(hatchback));

            TransmissionEntity automatic = transmissionRepository.findByTransmission(TransmisionEnum.AUTOMATIC);
            modelBmwX6.setTransmission(List.of(automatic));

            VehicleYearEntity byVehicleYear = vehicleYearRepository.findByVehicleYear(2007);
            VehicleYearEntity byVehicleYear1 = vehicleYearRepository.findByVehicleYear(2016);
            VehicleYearEntity byVehicleYear2 = vehicleYearRepository.findByVehicleYear(2021);
            modelBmwX6.setVehicleYear(List.of(byVehicleYear1,byVehicleYear2,byVehicleYear));



            ModelEntity modelBmwX7 = new ModelEntity();
            modelBmwX7.setBrand(bmw);
            modelBmwX7.setModelName("X7");
            modelBmwX7.setFuelType(List.of(gasoline,diesel));
            modelBmwX7.setVehicleCoupe(List.of(hatchback));
            modelBmwX7.setTransmission(List.of(automatic));
            modelBmwX7.setVehicleYear(List.of(byVehicleYear1,byVehicleYear2,byVehicleYear));

            modelRepository.saveAll(List.of(modelBmwX6,modelBmwX7));
        }
    }

    private void initBrands() {

        if (brandRepository.findAll().isEmpty()) {
            VehicleCategoryEntity byVehicleCategoryName = vehicleCategoryRepository.findByVehicleCategoryName(VehicleCategoryEnum.CAR);


            BrandEntity brandBmw = new BrandEntity();
            brandBmw.setCategory(byVehicleCategoryName);
            brandBmw.setBrandName("BMW");

            BrandEntity brandMercedes = new BrandEntity();
            brandMercedes.setCategory(byVehicleCategoryName);
            brandMercedes.setBrandName("MERCEDES-BENZ");

            BrandEntity brandAudi = new BrandEntity();
            brandAudi.setCategory(byVehicleCategoryName);
            brandAudi.setBrandName("AUDI");

            brandRepository.saveAll(List.of(brandBmw,brandAudi,brandMercedes));
        }
    }


    private void initUsers() {

        Optional<UserEntity> byEmail = userRepository.findByEmail("admin@abv.bg");


        if (byEmail.isEmpty()) {
            CityVillageEntity cityVillageEntity = cityVillageRepository.getAllCityVillageByRegionId(1L).get(0);

            System.out.println(cityVillageEntity.getCityVillageName());

            RoleEntity admin = roleRepository.findByRole(RoleEnum.ADMINISTRATOR);
            admin.setRole(RoleEnum.ADMINISTRATOR);

            UserEntity user = new UserEntity();
            user
                   .setCityVillage(cityVillageEntity);

            user
                    .setFirstName("admin")
                    .setLastName("admin")
                    .setEmail("admin@abv.bg")
                    .setPassword(passwordEncoder.encode("12345"))
                    .getRole().add(admin);
            user
                    .setModified(Instant.now())
                    .setCreated(Instant.now());
            userRepository.save(user);
        }

    }

    private void initFuelType() {

        if (fuelTypeRepository.findAll().isEmpty()) {
            FuelTypeEntity fuel1 = new FuelTypeEntity();
            fuel1.setName(FuelTypeEnum.GAS);

            FuelTypeEntity fuel2 = new FuelTypeEntity();
            fuel2.setName(FuelTypeEnum.GASOLINE);

            FuelTypeEntity fuel3 = new FuelTypeEntity();
            fuel3.setName(FuelTypeEnum.DIESEL);

            FuelTypeEntity fuel4 = new FuelTypeEntity();
            fuel4.setName(FuelTypeEnum.HYBRID);

            FuelTypeEntity fuel5 = new FuelTypeEntity();
            fuel5.setName(FuelTypeEnum.METHANE);

            fuelTypeRepository.saveAll(List.of(fuel1,fuel2,fuel3,fuel4,fuel5));
        }

    }

    private void initCarCategories() {

        if (vehicleCategoryRepository.findAll().isEmpty()){
            VehicleCategoryEntity carCategory1 = new VehicleCategoryEntity();
            carCategory1.setVehicleCategoryName(VehicleCategoryEnum.CAR);

            VehicleCategoryEntity carCategory2 = new VehicleCategoryEntity();
            carCategory2.setVehicleCategoryName(VehicleCategoryEnum.BUS);

            VehicleCategoryEntity carCategory3 = new VehicleCategoryEntity();
            carCategory3.setVehicleCategoryName(VehicleCategoryEnum.MOTORCYCLE);

            VehicleCategoryEntity carCategory4 = new VehicleCategoryEntity();
            carCategory4.setVehicleCategoryName(VehicleCategoryEnum.TRUCK);

            vehicleCategoryRepository.saveAll(List.of(carCategory1,carCategory2,carCategory3,carCategory4));
        }

    }

    private void initTransmission() {

        if (transmissionRepository.findAll().isEmpty()) {
            TransmissionEntity transsmission1 = new TransmissionEntity();
            transsmission1.setTransmission(TransmisionEnum.AUTOMATIC);

            TransmissionEntity transsmission2 = new TransmissionEntity();
            transsmission2.setTransmission(TransmisionEnum.MANUAL);

            TransmissionEntity transsmission3 = new TransmissionEntity();
            transsmission3.setTransmission(TransmisionEnum.SEMIAUTOMATIC);

            transmissionRepository.saveAll(List.of(transsmission1, transsmission2, transsmission3));
        }
    }

    private void initCarCoupeTypes() {

        if (vehicleCoupeRepository.findAll().size() == 0) {
            VehicleCoupeEntity carCoupe1 = new VehicleCoupeEntity();
            carCoupe1.setVehicleCoupe(VehicleCoupeEnum.COUPE);

            VehicleCoupeEntity carCoupe2 = new VehicleCoupeEntity();
            carCoupe2.setVehicleCoupe(VehicleCoupeEnum.CONVERTIBLE);

            VehicleCoupeEntity carCoupe3 = new VehicleCoupeEntity();
            carCoupe3.setVehicleCoupe(VehicleCoupeEnum.HATCHBACK);

            VehicleCoupeEntity carCoupe4 = new VehicleCoupeEntity();
            carCoupe4.setVehicleCoupe(VehicleCoupeEnum.JEEP);

            VehicleCoupeEntity carCoupe5 = new VehicleCoupeEntity();
            carCoupe5.setVehicleCoupe(VehicleCoupeEnum.PICKUP);

            VehicleCoupeEntity carCoupe6 = new VehicleCoupeEntity();
            carCoupe6.setVehicleCoupe(VehicleCoupeEnum.SEDAN);

            VehicleCoupeEntity carCoupe7 = new VehicleCoupeEntity();
            carCoupe7.setVehicleCoupe(VehicleCoupeEnum.VAN);

            vehicleCoupeRepository.saveAll(List.of(carCoupe1
                    , carCoupe2, carCoupe3, carCoupe4, carCoupe5
                    , carCoupe6, carCoupe7));
        }


    }

    private void initRoles() {

        if (roleRepository.findAll().size() == 0) {
            RoleEntity roleAdministrator = new RoleEntity();
            roleAdministrator.setRole(RoleEnum.ADMINISTRATOR);

            RoleEntity roleUser = new RoleEntity();
            roleUser.setRole(RoleEnum.USER);

            roleRepository.saveAll(List.of(roleAdministrator, roleUser));

        }
    }
}
