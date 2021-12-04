package com.example.carssale.model.entity.enums;

public enum CarYearEnum {
    YEAR1(1998),
    YEAR2(1999),
    YEAR3(2000),
    YEAR4(2001),
    YEAR5(2002),
    YEAR6(2003),
    YEAR7(2004),
    YEAR8(2005),
    YEAR9(2006),
    YEAR10(2007),
    YEAR11(2008),
    YEAR12(2009),
    YEAR13(2010),
    YEAR14(2011),
    YEAR15(2012),
    YEAR16(2013),
    YEAR17(2014),
    YEAR18(2015),
    YEAR19(2016),
    YEAR20(2017),
    YEAR21(2018),
    YEAR22(2019),
    YEAR23(2020),
    YEAR24(2021),
    YEAR25(2022);


    private final int value;

    CarYearEnum(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }

}
