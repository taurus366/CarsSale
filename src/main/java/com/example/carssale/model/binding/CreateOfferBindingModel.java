package com.example.carssale.model.binding;

import com.example.carssale.model.entity.ModelEntity;
import com.example.carssale.model.entity.enums.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

public class CreateOfferBindingModel {

    @NotNull
    private Integer doorCount;

    @NotNull
    private String emissionClass;

    @NotNull
    private Integer vehicleYear;

    @NotNull
    @Positive
    private Integer price;

    @NotNull
    @NotBlank
    private String modification;

    @NotNull
    @Positive
    private Integer kilometer;

    @NotNull
    @Positive
    private Integer power;

    @NotNull
    private VehicleStatusEnum vehicleStatus;

    @NotNull
    private String statusUsed;

    @NotNull
    private VehicleCoupeEnum carCoupe;

    @NotNull
    private ExteriorColorEnum exteriorColor;

    @NotNull
    private FuelTypeEnum fuelType;

    @NotNull
    private ModelEntity model;

//    @NotNull
//    private OfferDescriptionEntity offerDescription;

    @NotNull
    private PriceTypeEnum priceType;

    @NotNull
    private TransmisionEnum transmission;

    @NotNull
    private List<MultipartFile> picture = new ArrayList<>();

    @NotNull
    private String brand;



//    private String abs;
//    private String esp;
//    private String cruiseControl;
//    private String alarmSystem;
//    private String bluetooth;
//    private String centralLocking;
//    private String electricitySideMirror;
//    private String electricityWindows;
//    private String immobilizer;
//    private String keylessCentralLock;
//    private String fogLamp;
//    private String rainSensor;
//    private String navigationSystem;
//    private String lightSensor;
//    private String ledHeadLights;
//    private String panoramicRoof;
//    private String sunRoof;
//    private String speedLimitControlSystem;
//    private String voiceControl;
//    private String headUpDisplay;
//    private String soundSystem;
//    private String sportSeats;
//    private String startStopSystem;
//    private String tractionControl;
//    private String tunerRadio;
//    private String usbPort;
//    private String airBag;
//    private String brakeAssist;
//    private String airCondition;
//    private String steeringWheelHeating;

    List<String> features = new ArrayList<>();

    public List<String> getFeatures() {
        return features;
    }

    public CreateOfferBindingModel setFeatures(List<String> features) {
        this.features = features;
        return this;
    }

    public String getStatusUsed() {
        return statusUsed;
    }

    public CreateOfferBindingModel setStatusUsed(String statusUsed) {
        this.statusUsed = statusUsed;
        return this;
    }

//    public String getAbs() {
//        return abs;
//    }
//
//    public CreateOfferBindingModel setAbs(String abs) {
//        this.abs = abs;
//        return this;
//    }
//
//    public String getEsp() {
//        return esp;
//    }
//
//    public CreateOfferBindingModel setEsp(String esp) {
//        this.esp = esp;
//        return this;
//    }
//
//    public String getCruiseControl() {
//        return cruiseControl;
//    }
//
//    public CreateOfferBindingModel setCruiseControl(String cruiseControl) {
//        this.cruiseControl = cruiseControl;
//        return this;
//    }
//
//    public String getAlarmSystem() {
//        return alarmSystem;
//    }
//
//    public CreateOfferBindingModel setAlarmSystem(String alarmSystem) {
//        this.alarmSystem = alarmSystem;
//        return this;
//    }
//
//    public String getBluetooth() {
//        return bluetooth;
//    }
//
//    public CreateOfferBindingModel setBluetooth(String bluetooth) {
//        this.bluetooth = bluetooth;
//        return this;
//    }
//
//    public String getCentralLocking() {
//        return centralLocking;
//    }
//
//    public CreateOfferBindingModel setCentralLocking(String centralLocking) {
//        this.centralLocking = centralLocking;
//        return this;
//    }
//
//    public String getElectricitySideMirror() {
//        return electricitySideMirror;
//    }
//
//    public CreateOfferBindingModel setElectricitySideMirror(String electricitySideMirror) {
//        this.electricitySideMirror = electricitySideMirror;
//        return this;
//    }
//
//    public String getElectricityWindows() {
//        return electricityWindows;
//    }
//
//    public CreateOfferBindingModel setElectricityWindows(String electricityWindows) {
//        this.electricityWindows = electricityWindows;
//        return this;
//    }
//
//    public String getImmobilizer() {
//        return immobilizer;
//    }
//
//    public CreateOfferBindingModel setImmobilizer(String immobilizer) {
//        this.immobilizer = immobilizer;
//        return this;
//    }
//
//    public String getKeylessCentralLock() {
//        return keylessCentralLock;
//    }
//
//    public CreateOfferBindingModel setKeylessCentralLock(String keylessCentralLock) {
//        this.keylessCentralLock = keylessCentralLock;
//        return this;
//    }
//
//    public String getFogLamp() {
//        return fogLamp;
//    }
//
//    public CreateOfferBindingModel setFogLamp(String fogLamp) {
//        this.fogLamp = fogLamp;
//        return this;
//    }
//
//    public String getRainSensor() {
//        return rainSensor;
//    }
//
//    public CreateOfferBindingModel setRainSensor(String rainSensor) {
//        this.rainSensor = rainSensor;
//        return this;
//    }
//
//    public String getNavigationSystem() {
//        return navigationSystem;
//    }
//
//    public CreateOfferBindingModel setNavigationSystem(String navigationSystem) {
//        this.navigationSystem = navigationSystem;
//        return this;
//    }
//
//    public String getLightSensor() {
//        return lightSensor;
//    }
//
//    public CreateOfferBindingModel setLightSensor(String lightSensor) {
//        this.lightSensor = lightSensor;
//        return this;
//    }
//
//    public String getLedHeadLights() {
//        return ledHeadLights;
//    }
//
//    public CreateOfferBindingModel setLedHeadLights(String ledHeadLights) {
//        this.ledHeadLights = ledHeadLights;
//        return this;
//    }
//
//    public String getPanoramicRoof() {
//        return panoramicRoof;
//    }
//
//    public CreateOfferBindingModel setPanoramicRoof(String panoramicRoof) {
//        this.panoramicRoof = panoramicRoof;
//        return this;
//    }
//
//    public String getSunRoof() {
//        return sunRoof;
//    }
//
//    public CreateOfferBindingModel setSunRoof(String sunRoof) {
//        this.sunRoof = sunRoof;
//        return this;
//    }
//
//    public String getSpeedLimitControlSystem() {
//        return speedLimitControlSystem;
//    }
//
//    public CreateOfferBindingModel setSpeedLimitControlSystem(String speedLimitControlSystem) {
//        this.speedLimitControlSystem = speedLimitControlSystem;
//        return this;
//    }
//
//    public String getVoiceControl() {
//        return voiceControl;
//    }
//
//    public CreateOfferBindingModel setVoiceControl(String voiceControl) {
//        this.voiceControl = voiceControl;
//        return this;
//    }
//
//    public String getHeadUpDisplay() {
//        return headUpDisplay;
//    }
//
//    public CreateOfferBindingModel setHeadUpDisplay(String headUpDisplay) {
//        this.headUpDisplay = headUpDisplay;
//        return this;
//    }
//
//    public String getSoundSystem() {
//        return soundSystem;
//    }
//
//    public CreateOfferBindingModel setSoundSystem(String soundSystem) {
//        this.soundSystem = soundSystem;
//        return this;
//    }
//
//    public String getSportSeats() {
//        return sportSeats;
//    }
//
//    public CreateOfferBindingModel setSportSeats(String sportSeats) {
//        this.sportSeats = sportSeats;
//        return this;
//    }
//
//    public String getStartStopSystem() {
//        return startStopSystem;
//    }
//
//    public CreateOfferBindingModel setStartStopSystem(String startStopSystem) {
//        this.startStopSystem = startStopSystem;
//        return this;
//    }
//
//    public String getTractionControl() {
//        return tractionControl;
//    }
//
//    public CreateOfferBindingModel setTractionControl(String tractionControl) {
//        this.tractionControl = tractionControl;
//        return this;
//    }
//
//    public String getTunerRadio() {
//        return tunerRadio;
//    }
//
//    public CreateOfferBindingModel setTunerRadio(String tunerRadio) {
//        this.tunerRadio = tunerRadio;
//        return this;
//    }
//
//    public String getUsbPort() {
//        return usbPort;
//    }
//
//    public CreateOfferBindingModel setUsbPort(String usbPort) {
//        this.usbPort = usbPort;
//        return this;
//    }
//
//    public String getAirBag() {
//        return airBag;
//    }
//
//    public CreateOfferBindingModel setAirBag(String airBag) {
//        this.airBag = airBag;
//        return this;
//    }
//
//    public String getBrakeAssist() {
//        return brakeAssist;
//    }
//
//    public CreateOfferBindingModel setBrakeAssist(String brakeAssist) {
//        this.brakeAssist = brakeAssist;
//        return this;
//    }
//
//    public String getAirCondition() {
//        return airCondition;
//    }
//
//    public CreateOfferBindingModel setAirCondition(String airCondition) {
//        this.airCondition = airCondition;
//        return this;
//    }
//
//    public String getSteeringWheelHeating() {
//        return steeringWheelHeating;
//    }
//
//    public CreateOfferBindingModel setSteeringWheelHeating(String steeringWheelHeating) {
//        this.steeringWheelHeating = steeringWheelHeating;
//        return this;
//    }

    public String getBrand() {
        return brand;
    }

    public CreateOfferBindingModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public List<MultipartFile> getPicture() {
        return picture;
    }

    public CreateOfferBindingModel setPicture(List<MultipartFile> picture) {
        this.picture = picture;
        return this;
    }

    public Integer getDoorCount() {
        return doorCount;
    }

    public CreateOfferBindingModel setDoorCount(Integer doorCount) {
        this.doorCount = doorCount;
        return this;
    }

    public String getEmissionClass() {
        return emissionClass;
    }

    public CreateOfferBindingModel setEmissionClass(String emissionClass) {
        this.emissionClass = emissionClass;
        return this;
    }

    public Integer getVehicleYear() {
        return vehicleYear;
    }

    public CreateOfferBindingModel setVehicleYear(Integer vehicleYear) {
        this.vehicleYear = vehicleYear;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public CreateOfferBindingModel setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public String getModification() {
        return modification;
    }

    public CreateOfferBindingModel setModification(String modification) {
        this.modification = modification;
        return this;
    }

    public Integer getKilometer() {
        return kilometer;
    }

    public CreateOfferBindingModel setKilometer(Integer kilometer) {
        this.kilometer = kilometer;
        return this;
    }

    public Integer getPower() {
        return power;
    }

    public CreateOfferBindingModel setPower(Integer power) {
        this.power = power;
        return this;
    }

    public VehicleStatusEnum getVehicleStatus() {
        return vehicleStatus;
    }

    public CreateOfferBindingModel setVehicleStatus(VehicleStatusEnum vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
        return this;
    }

    public VehicleCoupeEnum getCarCoupe() {
        return carCoupe;
    }

    public CreateOfferBindingModel setCarCoupe(VehicleCoupeEnum carCoupe) {
        this.carCoupe = carCoupe;
        return this;
    }

    public ExteriorColorEnum getExteriorColor() {
        return exteriorColor;
    }

    public CreateOfferBindingModel setExteriorColor(ExteriorColorEnum exteriorColor) {
        this.exteriorColor = exteriorColor;
        return this;
    }

    public FuelTypeEnum getFuelType() {
        return fuelType;
    }

    public CreateOfferBindingModel setFuelType(FuelTypeEnum fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public CreateOfferBindingModel setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

//    public OfferDescriptionEntity getOfferDescription() {
//        return offerDescription;
//    }
//
//    public CreateOfferBindingModel setOfferDescription(OfferDescriptionEntity offerDescription) {
//        this.offerDescription = offerDescription;
//        return this;
//    }

    public PriceTypeEnum getPriceType() {
        return priceType;
    }

    public CreateOfferBindingModel setPriceType(PriceTypeEnum priceType) {
        this.priceType = priceType;
        return this;
    }

    public TransmisionEnum getTransmission() {
        return transmission;
    }

    public CreateOfferBindingModel setTransmission(TransmisionEnum transmission) {
        this.transmission = transmission;
        return this;
    }
}
