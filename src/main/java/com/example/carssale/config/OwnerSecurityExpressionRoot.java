package com.example.carssale.config;

import com.example.carssale.exception.NotAdministratorException;
import com.example.carssale.exception.NotOwnerException;
import com.example.carssale.exception.OfferNotFoundException;
import com.example.carssale.messages.Messages;
import com.example.carssale.service.OfferService;
import com.example.carssale.service.UserService;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public class OwnerSecurityExpressionRoot extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

    private UserService userService;
    private OfferService offerService;
    private Object returnObject;
    private Object filterObject;
    /**
     * Creates a new instance
     *
     * @param authentication the {@link Authentication} to use. Cannot be null.
     */
    public OwnerSecurityExpressionRoot(Authentication authentication) {
        super(authentication);
    }

    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    public boolean isOwner(Long offerId) {
        String userEmail = currentUserEmail();
        boolean isOwner = offerService.isOwnerTheOffer(offerId, userEmail);
        if (userEmail == null || !isOwner) {
            throw new NotOwnerException(1L, Messages.getOfferNotOwner(String.valueOf(offerId)));
        }
        return true;
    }

    public boolean isAdmin() {
        String userEmail = currentUserEmail();


        boolean isAdmin = userService.isAdmin(userEmail);
        if (!isAdmin || userEmail == null) {
            throw new NotAdministratorException("ttestADMIN");
            // TODO for admin message
        }

        return true;
    }


    // If String userEmail empty
    public String currentUserEmail() {
        Authentication authentication = getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            return (((UserDetails) authentication.getPrincipal()).getUsername());
        }
        return null;
    }

    @Override
    public void setFilterObject(Object filterObject) {
        this.filterObject = filterObject;
    }

    @Override
    public Object getFilterObject() {
        return filterObject;
    }

    @Override
    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    @Override
    public Object getReturnObject() {
        return returnObject;
    }

    @Override
    public Object getThis() {
        return this;
    }
}
