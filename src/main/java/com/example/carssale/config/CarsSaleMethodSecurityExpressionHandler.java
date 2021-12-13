package com.example.carssale.config;

import com.example.carssale.service.OfferService;
import com.example.carssale.service.UserService;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;

public class CarsSaleMethodSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {

    private final OfferService offerService;
    private final UserService userService;

    public CarsSaleMethodSecurityExpressionHandler(OfferService offerService, UserService userService) {
        this.offerService = offerService;
        this.userService = userService;
    }

    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, MethodInvocation invocation) {
         OwnerSecurityExpressionRoot root = new OwnerSecurityExpressionRoot(authentication);

        root.setOfferService(offerService);
        root.setPermissionEvaluator(getPermissionEvaluator());
        root.setTrustResolver(new AuthenticationTrustResolverImpl());
        root.setRoleHierarchy(getRoleHierarchy());
        root.setUserService(userService);
         return root;
    }
}
