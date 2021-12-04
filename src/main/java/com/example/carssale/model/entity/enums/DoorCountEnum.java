package com.example.carssale.model.entity.enums;

public enum DoorCountEnum {
   doorOne(1),
    doorTwo(2),
    doorThree(3),
    doorFour(4),
    doorFive(5);

    private final int value;

    DoorCountEnum(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
