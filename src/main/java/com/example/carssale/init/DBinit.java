package com.example.carssale.init;

import com.example.carssale.model.entity.*;
import com.example.carssale.model.entity.enums.*;
import com.example.carssale.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class DBinit implements CommandLineRunner {

    private final RoleRepository roleRepository;

    private final CarCoupeRepository carCoupeRepository;
    private final PriceTypeRepository priceTypeRepository;
    private final CarStatusRepository carStatusRepository;
    private final TranssmissionRepository transsmissionRepository;
    private final CarCategoryRepository carCategoryRepository;
    private final FuelTypeRepository fuelTypeRepository;
    private final UserRepository userRepository;
    private final RegionRepository regionRepository;
    private final CityVillageRepository cityVillageRepository;


    public DBinit(RoleRepository roleRepository, CarCoupeRepository carCoupeRepository, PriceTypeRepository priceTypeRepository, CarStatusRepository carStatusRepository, TranssmissionRepository transsmissionRepository, CarCategoryRepository carCategoryRepository, FuelTypeRepository fuelTypeRepository, UserRepository userRepository, RegionRepository regionRepository, CityVillageRepository cityVillageRepository) {
        this.roleRepository = roleRepository;
        this.carCoupeRepository = carCoupeRepository;
        this.priceTypeRepository = priceTypeRepository;
        this.carStatusRepository = carStatusRepository;
        this.transsmissionRepository = transsmissionRepository;
        this.carCategoryRepository = carCategoryRepository;
        this.fuelTypeRepository = fuelTypeRepository;
        this.userRepository = userRepository;
        this.regionRepository = regionRepository;
        this.cityVillageRepository = cityVillageRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        initRoles();
        initCarCoupeTypes();
        initPriceType();
        initCarStatus();
        initTranssmission();
        initCarCategories();
        initFuelType();

//        initUsers();

    }



    private void initUsers() {

        if (userRepository.findAll().isEmpty()) {
            UserEntity user = new UserEntity();
            user.setFirstName("test")
                    .setEmail("tausadas@abv.bg")
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
            fuel2.setName(FuelTypeEnum.BENZIN);

            FuelTypeEntity fuel3 = new FuelTypeEntity();
            fuel3.setName(FuelTypeEnum.DIESEL);

            FuelTypeEntity fuel4 = new FuelTypeEntity();
            fuel4.setName(FuelTypeEnum.HYBRID);

            FuelTypeEntity fuel5 = new FuelTypeEntity();
            fuel5.setName(FuelTypeEnum.METAN);

            fuelTypeRepository.saveAll(List.of(fuel1,fuel2,fuel3,fuel4,fuel5));
        }

    }

    private void initCarCategories() {

        if (carCategoryRepository.findAll().isEmpty()){
            CarCategoryEntity carCategory1 = new CarCategoryEntity();
            carCategory1.setCarCategoryEnum(CarCategoryEnum.CAR);

            CarCategoryEntity carCategory2 = new CarCategoryEntity();
            carCategory2.setCarCategoryEnum(CarCategoryEnum.BUS);

            CarCategoryEntity carCategory3 = new CarCategoryEntity();
            carCategory3.setCarCategoryEnum(CarCategoryEnum.MOTORCYCLE);

            CarCategoryEntity carCategory4 = new CarCategoryEntity();
            carCategory4.setCarCategoryEnum(CarCategoryEnum.TRUCK);

            carCategoryRepository.saveAll(List.of(carCategory1,carCategory2,carCategory3,carCategory4));
        }

    }

    private void initTranssmission() {

        if (transsmissionRepository.findAll().isEmpty()) {
            TranssmissionEntity transsmission1 = new TranssmissionEntity();
            transsmission1.setTranssmission(TranssmissionEnum.AUTOMATIC);

            TranssmissionEntity transsmission2 = new TranssmissionEntity();
            transsmission2.setTranssmission(TranssmissionEnum.MANUAL);

            TranssmissionEntity transsmission3 = new TranssmissionEntity();
            transsmission3.setTranssmission(TranssmissionEnum.SEMIAUTOMATIC);

            transsmissionRepository.saveAll(List.of(transsmission1, transsmission2, transsmission3));
        }
    }

    private void initCarStatus() {
        if (carStatusRepository.findAll().isEmpty()) {
            CarStatusEntity carStatus1 = new CarStatusEntity();
            carStatus1.setCarStatus(CarStatusEnum.IN_GOOD_CONDITION);

            CarStatusEntity carStatus2 = new CarStatusEntity();
            carStatus2.setCarStatus(CarStatusEnum.WHOLE_CAR_FOR_PARTS);

            CarStatusEntity carStatus3 = new CarStatusEntity();
            carStatus3.setCarStatus(CarStatusEnum.DAMAGED_HIT);

            carStatusRepository.saveAll(List.of(carStatus1, carStatus2, carStatus3));
        }
    }

    private void initPriceType() {
        if (priceTypeRepository.findAll().isEmpty()) {
            PriceTypeEntity price1 = new PriceTypeEntity();
            price1.setPriceType(PriceTypeEnum.BGN);

            PriceTypeEntity price2 = new PriceTypeEntity();
            price2.setPriceType(PriceTypeEnum.EUR);

            PriceTypeEntity price3 = new PriceTypeEntity();
            price3.setPriceType(PriceTypeEnum.USD);

            priceTypeRepository.saveAll(List.of(price1, price2, price3));

        }
    }

    private void initCarCoupeTypes() {

        if (carCoupeRepository.findAll().size() == 0) {
            CarCoupeEntity carCoupe1 = new CarCoupeEntity();
            carCoupe1.setCarCoupe(CarCoupeEnum.COUPE);

            CarCoupeEntity carCoupe2 = new CarCoupeEntity();
            carCoupe2.setCarCoupe(CarCoupeEnum.CONVERTIBLE);

            CarCoupeEntity carCoupe3 = new CarCoupeEntity();
            carCoupe3.setCarCoupe(CarCoupeEnum.HATCHBACK);

            CarCoupeEntity carCoupe4 = new CarCoupeEntity();
            carCoupe4.setCarCoupe(CarCoupeEnum.JEEP);

            CarCoupeEntity carCoupe5 = new CarCoupeEntity();
            carCoupe5.setCarCoupe(CarCoupeEnum.PICKUP);

            CarCoupeEntity carCoupe6 = new CarCoupeEntity();
            carCoupe6.setCarCoupe(CarCoupeEnum.SEDAN);

            CarCoupeEntity carCoupe7 = new CarCoupeEntity();
            carCoupe7.setCarCoupe(CarCoupeEnum.VAN);

            carCoupeRepository.saveAll(List.of(carCoupe1
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
