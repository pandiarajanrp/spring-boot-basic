package com.learn.springboot.learnspringboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import util.Coach;

@RestController
public class TennisCoachController {
    private Coach coach;
    @Autowired
    public TennisCoachController(@Qualifier("tennisCoach") Coach tennisCoach) {
        this.coach = tennisCoach;
    }
//    @Autowired
//    public void setCricketCoach(Coach cricketCoach) {
//        this.cricketCoach = cricketCoach;
//    }

    @GetMapping("/get-daily-workout-tennis")
    public String getWorkoutForCricket() {
        return this.coach.getDailyWorkouts();
    }
}
