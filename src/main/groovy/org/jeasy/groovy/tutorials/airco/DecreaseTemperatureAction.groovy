package org.jeasy.groovy.tutorials.airco;

import org.jeasy.rules.api.Action;
import org.jeasy.rules.api.Facts;

public class DecreaseTemperatureAction implements Action {

    static DecreaseTemperatureAction decreaseTemperature() {
        return new DecreaseTemperatureAction();
    }

    @Override
    public void execute(Facts facts) throws Exception {

        int temperature = facts.get('temperature')

        println("It is $temperature, way too hot! Cooling air...")
        facts.put('temperature', temperature - 1)
    }
}
