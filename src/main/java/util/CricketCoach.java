package util;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkouts() {
        return "Practice fast bowling for 30 mins daily";
    }

    @PostConstruct
    public void initConstruct() {
        System.out.println("Container Initiated !!!!");
    }

    @PreDestroy
    public void beforeDestroy() {
        System.out.println("Before Destroy");
    }
}
