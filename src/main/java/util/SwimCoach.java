package util;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class SwimCoach implements Coach{
    @Override
    public String getDailyWorkouts() {
        return "Practice 300m swimming daily";
    }
}
