package util;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkouts() {
        return "Practice fast bowling for 30 mins daily";
    }
}
