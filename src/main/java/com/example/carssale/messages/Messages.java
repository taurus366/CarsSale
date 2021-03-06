package com.example.carssale.messages;

public class Messages {
    public static String OFFER_NOT_FOUND = "Cannot find Car Offer with id: ";
    public static String OFFER_NOT_OWNER = "You are not the owner of offer with id: %s";
    public static String NOT_ADMINISTRATOR = "Only Administrators can use this function";


    public static String getOfferNotFound(String id) {
       return String.format(OFFER_NOT_FOUND, id);
    }

    public static String getOfferNotOwner(String id) {
       return String.format(OFFER_NOT_OWNER, id);
    }

    public static String getNotAdministrator() {
        return NOT_ADMINISTRATOR;
    }
}
