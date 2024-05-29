package util;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkouts() {
        return "Practice tennis for 30 mins daily";
    }
}
