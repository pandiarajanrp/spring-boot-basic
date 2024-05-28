package util;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkouts() {
        return "Practice tennis for 30 mins daily";
    }
}
