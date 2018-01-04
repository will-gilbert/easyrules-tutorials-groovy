package org.jeasy.groovy.tutorials.weather

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = 'weather rule', description = 'if it rains then take an umbrella' )
public class WeatherRule {

    @Condition
    public boolean itRains(@Fact("It's raining") boolean isRaining) {
        return isRaining
    }
    
    @Action
    public void takeAnUmbrella() {
        println 'It is raining, take an umbrella!'
    }
}