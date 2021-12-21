package com.example.carssale.web;

import com.example.carssale.service.StatsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class StatsController {

    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/statistics")
    public ModelAndView statistics() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("stats", statsService.getStats());
        modelAndView.setViewName("statistics");
        return modelAndView;
    }
}
