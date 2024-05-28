package com.learn.springboot.learnspringboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import util.Coach;

@RestController
public class GetCricketScheduleController {
    private Coach cricketCoach;
//    @Autowired
//    public GetCricketScheduleController(Coach cricketCoach) {
//        this.cricketCoach = cricketCoach;
//    }
    @Autowired
    public void setCricketCoach(Coach cricketCoach) {
        this.cricketCoach = cricketCoach;
    }

    @GetMapping("/get-daily-workout")
    public String getWorkoutForCricket() {
        return this.cricketCoach.getDailyWorkouts();
    }
}
