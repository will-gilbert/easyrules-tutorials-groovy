package org.jeasy.groovy.tutorials.fire.rules

import org.jeasy.rules.annotation.Action
import org.jeasy.rules.annotation.Condition
import org.jeasy.rules.annotation.Fact
import org.jeasy.rules.annotation.Rule
import org.jeasy.rules.annotation.Priority

import org.jeasy.rules.api.Facts;

@Rule(description='All the fires are out, cancel the alarm')
class CancelAlarmRule {

    @Condition
    public boolean when( Facts facts ) {
    	facts['alarm'] && facts['fires']?.size() == 0
    }

    @Action
    void then( @Fact('alarm') alarm) { 
        println( "Cancel the Alarm");
        facts.remove(alarm)
    }

    @Priority
    int getPriority() { 1 }

}
