package com.learn.springboot.learnspringboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import util.Coach;

@RestController
public class CricketCoachController {
    private Coach coach;
//    @Autowired
//    public GetCricketScheduleController(Coach cricketCoach) {
//        this.cricketCoach = cricketCoach;
//    }
    @Autowired
    public void setCricketCoach(@Qualifier("cricketCoach") Coach cricketCoach) {
        this.coach = cricketCoach;
    }

    @GetMapping("/get-daily-workout-cricket")
    public String getWorkoutForCricket() {
        return this.coach.getDailyWorkouts();
    }
}
