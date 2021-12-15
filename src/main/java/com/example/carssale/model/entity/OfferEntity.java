package com.example.carssale.model.entity;

import com.example.carssale.model.entity.enums.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    @ManyToOne
    private UserEntity user;

    private Integer doorCount;

    private String emissionClass;

    private Integer vehicleYear;

    private Integer price;

    private String modification;

    private Integer kilometer;

    private Integer power;

    private String abs;
    private String esp;
    private String cruiseControl;
    private String alarmSystem;
    private String bluetooth;
    private String centralLocking;
    private String electricitySideMirror;
    private String electricityWindows;
    private String immobilizer;
    private String keylessCentralLock;
    private String fogLamp;
    private String rainSensor;
    private String navigationSystem;
    private String lightSensor;
    private String ledHeadLights;
    private String panoramicRoof;
    private String sunRoof;
    private String speedLimitControlSystem;
    private String voiceControl;
    private String headUpDisplay;
    private String soundSystem;
    private String sportSeats;
    private String startStopSystem;
    private String tractionControl;
    private String tunerRadio;
    private String usbPort;
    private String airBag;
    private String brakeAssist;
    private String airCondition;
    private String steeringWheelHeating;

    @Column
    @Enumerated(EnumType.STRING)
    private StatusUsedEnum statusUsed;

    @Column()
    @Enumerated(EnumType.STRING)
    private VehicleCoupeEnum carCoupe;

    @Column()
    @Enumerated(EnumType.STRING)
    private VehicleStatusEnum vehicleStatus;

    @Column
    @Enumerated(EnumType.STRING)
    private ExteriorColorEnum exteriorColor;

    @Column
    @Enumerated(EnumType.STRING)
    private FuelTypeEnum fuelType;

    @ManyToOne(fetch = FetchType.EAGER)
    private ModelEntity model;

    @OneToMany(cascade = {CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PictureEntity> pictures = new ArrayList<>();

//    @OneToOne
//    private OfferDescriptionEntity offerDescription;

    @Column
    @Enumerated(EnumType.STRING)
    private PriceTypeEnum priceType;

    @Column
    @Enumerated(EnumType.STRING)
    private TransmisionEnum transmission;


    public OfferEntity() {
    }

    public String getAbs() {
        return abs;
    }

    public OfferEntity setAbs(String abs) {
        this.abs = abs;
        return this;
    }

    public String getEsp() {
        return esp;
    }

    public OfferEntity setEsp(String esp) {
        this.esp = esp;
        return this;
    }

    public String getCruiseControl() {
        return cruiseControl;
    }

    public OfferEntity setCruiseControl(String cruiseControl) {
        this.cruiseControl = cruiseControl;
        return this;
    }

    public String getAlarmSystem() {
        return alarmSystem;
    }

    public OfferEntity setAlarmSystem(String alarmSystem) {
        this.alarmSystem = alarmSystem;
        return this;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public OfferEntity setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
        return this;
    }

    public String getCentralLocking() {
        return centralLocking;
    }

    public OfferEntity setCentralLocking(String centralLocking) {
        this.centralLocking = centralLocking;
        return this;
    }

    public String getElectricitySideMirror() {
        return electricitySideMirror;
    }

    public OfferEntity setElectricitySideMirror(String electricitySideMirror) {
        this.electricitySideMirror = electricitySideMirror;
        return this;
    }

    public String getElectricityWindows() {
        return electricityWindows;
    }

    public OfferEntity setElectricityWindows(String electricityWindows) {
        this.electricityWindows = electricityWindows;
        return this;
    }

    public String getImmobilizer() {
        return immobilizer;
    }

    public OfferEntity setImmobilizer(String immobilizer) {
        this.immobilizer = immobilizer;
        return this;
    }

    public String getKeylessCentralLock() {
        return keylessCentralLock;
    }

    public OfferEntity setKeylessCentralLock(String keylessCentralLock) {
        this.keylessCentralLock = keylessCentralLock;
        return this;
    }

    public String getFogLamp() {
        return fogLamp;
    }

    public OfferEntity setFogLamp(String fogLamp) {
        this.fogLamp = fogLamp;
        return this;
    }

    public String getRainSensor() {
        return rainSensor;
    }

    public OfferEntity setRainSensor(String rainSensor) {
        this.rainSensor = rainSensor;
        return this;
    }

    public String getNavigationSystem() {
        return navigationSystem;
    }

    public OfferEntity setNavigationSystem(String navigationSystem) {
        this.navigationSystem = navigationSystem;
        return this;
    }

    public String getLightSensor() {
        return lightSensor;
    }

    public OfferEntity setLightSensor(String lightSensor) {
        this.lightSensor = lightSensor;
        return this;
    }

    public String getLedHeadLights() {
        return ledHeadLights;
    }

    public OfferEntity setLedHeadLights(String ledHeadLights) {
        this.ledHeadLights = ledHeadLights;
        return this;
    }

    public String getPanoramicRoof() {
        return panoramicRoof;
    }

    public OfferEntity setPanoramicRoof(String panoramicRoof) {
        this.panoramicRoof = panoramicRoof;
        return this;
    }

    public String getSunRoof() {
        return sunRoof;
    }

    public OfferEntity setSunRoof(String sunRoof) {
        this.sunRoof = sunRoof;
        return this;
    }

    public String getSpeedLimitControlSystem() {
        return speedLimitControlSystem;
    }

    public OfferEntity setSpeedLimitControlSystem(String speedLimitControlSystem) {
        this.speedLimitControlSystem = speedLimitControlSystem;
        return this;
    }

    public String getVoiceControl() {
        return voiceControl;
    }

    public OfferEntity setVoiceControl(String voiceControl) {
        this.voiceControl = voiceControl;
        return this;
    }

    public String getHeadUpDisplay() {
        return headUpDisplay;
    }

    public OfferEntity setHeadUpDisplay(String headUpDisplay) {
        this.headUpDisplay = headUpDisplay;
        return this;
    }

    public String getSoundSystem() {
        return soundSystem;
    }

    public OfferEntity setSoundSystem(String soundSystem) {
        this.soundSystem = soundSystem;
        return this;
    }

    public String getSportSeats() {
        return sportSeats;
    }

    public OfferEntity setSportSeats(String sportSeats) {
        this.sportSeats = sportSeats;
        return this;
    }

    public String getStartStopSystem() {
        return startStopSystem;
    }

    public OfferEntity setStartStopSystem(String startStopSystem) {
        this.startStopSystem = startStopSystem;
        return this;
    }

    public String getTractionControl() {
        return tractionControl;
    }

    public OfferEntity setTractionControl(String tractionControl) {
        this.tractionControl = tractionControl;
        return this;
    }

    public String getTunerRadio() {
        return tunerRadio;
    }

    public OfferEntity setTunerRadio(String tunerRadio) {
        this.tunerRadio = tunerRadio;
        return this;
    }

    public String getUsbPort() {
        return usbPort;
    }

    public OfferEntity setUsbPort(String usbPort) {
        this.usbPort = usbPort;
        return this;
    }

    public String getAirBag() {
        return airBag;
    }

    public OfferEntity setAirBag(String airBag) {
        this.airBag = airBag;
        return this;
    }

    public String getBrakeAssist() {
        return brakeAssist;
    }

    public OfferEntity setBrakeAssist(String brakeAssist) {
        this.brakeAssist = brakeAssist;
        return this;
    }

    public String getAirCondition() {
        return airCondition;
    }

    public OfferEntity setAirCondition(String airCondition) {
        this.airCondition = airCondition;
        return this;
    }

    public String getSteeringWheelHeating() {
        return steeringWheelHeating;
    }

    public OfferEntity setSteeringWheelHeating(String steeringWheelHeating) {
        this.steeringWheelHeating = steeringWheelHeating;
        return this;
    }

    public List<PictureEntity> getPictures() {
        return pictures;
    }

    public OfferEntity setPictures(List<PictureEntity> pictures) {
        this.pictures = pictures;
        return this;
    }

    public StatusUsedEnum getStatusUsed() {
        return statusUsed;
    }

    public OfferEntity setStatusUsed(StatusUsedEnum statusUsed) {
        this.statusUsed = statusUsed;
        return this;
    }

    public Integer getPower() {
        return power;
    }

    public OfferEntity setPower(Integer power) {
        this.power = power;
        return this;
    }

    public Integer getKilometer() {
        return kilometer;
    }

    public OfferEntity setKilometer(Integer kilometer) {
        this.kilometer = kilometer;
        return this;
    }

    public String getModification() {
        return modification;
    }

    public OfferEntity setModification(String modification) {
        this.modification = modification;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public OfferEntity setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public OfferEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public Integer getDoorCount() {
        return doorCount;
    }

    public OfferEntity setDoorCount(Integer doorCount) {
        this.doorCount = doorCount;
        return this;
    }

    public String getEmissionClass() {
        return emissionClass;
    }

    public OfferEntity setEmissionClass(String emissionClass) {
        this.emissionClass = emissionClass;
        return this;
    }

    public Integer getVehicleYear() {
        return vehicleYear;
    }

    public OfferEntity setVehicleYear(Integer vehicleYear) {
        this.vehicleYear = vehicleYear;
        return this;
    }

    public VehicleCoupeEnum getCarCoupe() {
        return carCoupe;
    }

    public OfferEntity setCarCoupe(VehicleCoupeEnum carCoupe) {
        this.carCoupe = carCoupe;
        return this;
    }

    public VehicleStatusEnum getVehicleStatus() {
        return vehicleStatus;
    }

    public OfferEntity setVehicleStatus(VehicleStatusEnum vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
        return this;
    }

    public ExteriorColorEnum getExteriorColor() {
        return exteriorColor;
    }

    public OfferEntity setExteriorColor(ExteriorColorEnum exteriorColor) {
        this.exteriorColor = exteriorColor;
        return this;
    }

    public FuelTypeEnum getFuelType() {
        return fuelType;
    }

    public OfferEntity setFuelType(FuelTypeEnum fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OfferEntity setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

//    public OfferDescriptionEntity getOfferDescription() {
//        return offerDescription;
//    }
//
//    public OfferEntity setOfferDescription(OfferDescriptionEntity offerDescription) {
//        this.offerDescription = offerDescription;
//        return this;
//    }

    public PriceTypeEnum getPriceType() {
        return priceType;
    }

    public OfferEntity setPriceType(PriceTypeEnum priceType) {
        this.priceType = priceType;
        return this;
    }

    public TransmisionEnum getTransmission() {
        return transmission;
    }

    public OfferEntity setTransmission(TransmisionEnum transmission) {
        this.transmission = transmission;
        return this;
    }
}
