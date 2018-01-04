package org.jeasy.groovy.tutorials.airco

import org.jeasy.rules.api.Condition
import org.jeasy.rules.api.Facts

public class HighTemperatureCondition implements Condition {

    static HighTemperatureCondition itIsHot() {
        return new HighTemperatureCondition()
    }

    @Override
    public boolean evaluate(Facts facts) {

        int temperature = facts.get('temperature')
        int target = facts.get('target')

        return temperature > target
    }

}
