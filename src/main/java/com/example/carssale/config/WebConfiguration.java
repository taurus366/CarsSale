package com.example.carssale.config;

import com.example.carssale.interceptors.StatsInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final LocaleChangeInterceptor localeChangeInterceptor;
    private final StatsInterceptor statsInterceptor;

    public WebConfiguration(LocaleChangeInterceptor localeChangeInterceptor, StatsInterceptor statsInterceptor) {
        this.localeChangeInterceptor = localeChangeInterceptor;
        this.statsInterceptor = statsInterceptor;
    }

    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(localeChangeInterceptor);
        registry.addInterceptor(statsInterceptor);
    }

    //    private final StatsInterceptor

    // TODO
}
