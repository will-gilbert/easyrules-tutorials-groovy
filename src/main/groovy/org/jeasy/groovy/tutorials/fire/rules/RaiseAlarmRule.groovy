package org.jeasy.groovy.tutorials.fire.rules

import org.jeasy.groovy.tutorials.fire.beans.Alarm

import org.jeasy.rules.annotation.Action
import org.jeasy.rules.annotation.Condition
import org.jeasy.rules.annotation.Fact
import org.jeasy.rules.annotation.Rule
import org.jeasy.rules.annotation.Priority

import org.jeasy.rules.api.Facts;

@Rule(description='A fire will raise an alarm')
class RaiseAlarmRule {

    @Condition
    boolean when(Facts facts) {
    	facts['fires'].size() > 0 && !facts['alarm']
    }

    @Action
    void then(Facts facts) { 
    	facts.put 'alarm', new Alarm('123 Main Street')
        println( "Raise an alarm");
    }

    @Priority
    int getPriority() { 2 }

}
