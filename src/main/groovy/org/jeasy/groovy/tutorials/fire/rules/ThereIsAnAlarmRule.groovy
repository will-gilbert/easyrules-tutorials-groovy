package org.jeasy.groovy.tutorials.fire.rules

import org.jeasy.rules.annotation.Action
import org.jeasy.rules.annotation.Condition
import org.jeasy.rules.annotation.Fact
import org.jeasy.rules.annotation.Rule
import org.jeasy.rules.annotation.Priority

import org.jeasy.rules.api.Facts;

@Rule(description='The alarm is detected at the fire station')
class ThereIsAnAlarmRule {

    @Condition
    boolean when( Facts facts ) {
    	facts['alarm'] != null
    }

    @Action
    void then(@Fact('alarm') alarm) { 
        println "At the Fire Station: There is an Alarm at ${alarm.address}"
    }

    @Priority
    int getPriority() { 5 }

}
