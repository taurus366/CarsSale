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


    public DBinit(RoleRepository roleRepository, VehicleCoupeRepository vehicleCoupeRepository, TransmissionRepository transmissionRepository, VehicleCategoryRepository vehicleCategoryRepository, FuelTypeRepository fuelTypeRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, ModelRepository modelRepository) {
        this.roleRepository = roleRepository;
        this.vehicleCoupeRepository = vehicleCoupeRepository;
        this.transmissionRepository = transmissionRepository;
        this.vehicleCategoryRepository = vehicleCategoryRepository;
        this.fuelTypeRepository = fuelTypeRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelRepository = modelRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        initRoles();
        initUsers();

        initTranssmission();
        initCarCoupeTypes();
        initFuelType();

        //TODO first init brands and models if table is empty! after that , set Model's [coupe,year,transmission,fuel] !
        initCarCategories();
//        initBrands();
//        initModels();
    }




    private void initUsers() {

        Optional<UserEntity> byEmail = userRepository.findByEmail("admin@abv.bg");


        if (byEmail.isEmpty()) {
            RoleEntity admin = roleRepository.findByRole(RoleEnum.ADMINISTRATOR);
            admin.setRole(RoleEnum.ADMINISTRATOR);

            UserEntity user = new UserEntity();
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
        System.out.println("test");
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

    private void initTranssmission() {

        if (transmissionRepository.findAll().isEmpty()) {
            TransmissionEntity transsmission1 = new TransmissionEntity();
            transsmission1.setTranssmission(TranssmissionEnum.AUTOMATIC);

            TransmissionEntity transsmission2 = new TransmissionEntity();
            transsmission2.setTranssmission(TranssmissionEnum.MANUAL);

            TransmissionEntity transsmission3 = new TransmissionEntity();
            transsmission3.setTranssmission(TranssmissionEnum.SEMIAUTOMATIC);

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
