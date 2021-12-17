package com.example.carssale.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass {

    private static final Logger LOGGER = LoggerFactory.getLogger(AspectClass.class);

    @Pointcut("execution(* com.example.carssale.schedule.ScheduleApplication.updateRegionAndCityCache(..))")
    public void trackUpdateCityAndRegion() {
    }


    @Before("trackUpdateCityAndRegion()")
    public void BeforeStartUpdate(JoinPoint joinPoint) {
        LOGGER.info("Started to Update Region and Cities Scheduling : {}", "<>".repeat(50));
    }

    @AfterReturning(pointcut = "execution(* com.example.carssale.schedule.ScheduleApplication.updateRegionAndCityCache())")
    public void afterUpdatedFinished(JoinPoint joinPoint) {
        LOGGER.info("Finished to Update Region and Cities Scheduling : {}", "-".repeat(50));
    }

}
