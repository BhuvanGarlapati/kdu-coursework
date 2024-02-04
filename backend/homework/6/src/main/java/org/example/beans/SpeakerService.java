package org.example.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpeakerService{
    private static final double SONY_PRICE =15000;
    private static final double BOSE_PRICE =8000;
    @Bean
    public Speaker generateSpeaker(){
        if(Math.random()>0.5){
            return new Speaker(SpeakerBrand.SONY,SONY_PRICE);
        }
        else{
            return new Speaker(SpeakerBrand.BOSE,BOSE_PRICE);
        }
    }
}