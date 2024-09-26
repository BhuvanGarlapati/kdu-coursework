package org.example.config;

import org.example.beans.SpeakerService;
import org.example.beans.TyreService;
import org.example.beans.VehicleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "org.example.beans")
public class ProjectConfig{
    @Bean
    public VehicleService vehicleService() {
        return new VehicleService();
    }

    @Bean
    public TyreService tyreService() {
        return new TyreService();
    }

    @Bean
    public SpeakerService speakerService() {
        return new SpeakerService();
    }

}