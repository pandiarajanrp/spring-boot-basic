package com.learn.springboot.learnspringboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import util.Coach;

@RestController
public class CricketCoachController {
    private Coach coach;
    private Coach newCoach;
//    @Autowired
//    public GetCricketScheduleController(Coach cricketCoach) {
//        this.cricketCoach = cricketCoach;
//    }
    @Autowired
    public void setCricketCoach(@Qualifier("swimCoach") Coach cricketCoach, @Qualifier("cricketCoach") Coach newCoach) {
        this.coach = cricketCoach;
        this.newCoach = newCoach;
    }

    @GetMapping("/get-daily-workout-cricket")
    public String getWorkoutForCricket() {
        Boolean same = coach == newCoach;
        System.out.println("is " + (same ? "same" : "not same"));
        return this.coach.getDailyWorkouts();
    }
}
