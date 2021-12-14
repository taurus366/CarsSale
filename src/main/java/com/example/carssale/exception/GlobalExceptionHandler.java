package com.example.carssale.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({OfferNotFoundException.class})
    public ModelAndView handleException(OfferNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView("offer-not-found");
        modelAndView
                .addObject("message", e.getMessage())
                .addObject("offerId", e.getOfferId());
        modelAndView.setStatus(HttpStatus.NOT_FOUND);

        return modelAndView;
    }

    @ExceptionHandler({NotOwnerException.class})
    public ModelAndView handleException(NotOwnerException e) {
        ModelAndView modelAndView = new ModelAndView("error/not-owner-exception");
        modelAndView
                .addObject("message" , e.getMessage());
        modelAndView.setStatus(HttpStatus.FORBIDDEN);

        return modelAndView;
    }

    @ExceptionHandler({NotAdministratorException.class})
    public ModelAndView handleException(NotAdministratorException e){
        ModelAndView modelAndView = new ModelAndView("error/not-owner-exception");
        modelAndView
                .addObject("message" , e.getMessage());
        modelAndView.setStatus(HttpStatus.FORBIDDEN);

        return modelAndView;
    }
}
