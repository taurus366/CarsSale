package com.example.carssale.config;

import com.example.carssale.service.OfferService;
import com.example.carssale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private CarsSaleMethodSecurityExpressionHandler carsSaleMethodSecurityExpressionHandler;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return carsSaleMethodSecurityExpressionHandler;
    }

    @Bean
    public CarsSaleMethodSecurityExpressionHandler createExpressionHandler(OfferService offerService, UserService userService) {
      return new CarsSaleMethodSecurityExpressionHandler(offerService, userService);
    }

}
