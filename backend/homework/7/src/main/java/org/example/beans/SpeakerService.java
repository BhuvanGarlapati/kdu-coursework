package org.example.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class SpeakerService {

    @Primary
    Speaker sonySpeaker() {
        return new Speaker("Sony", 15000);
    }

    Speaker boseSpeaker() {
        return new Speaker("Bose", 8000);
    }
}