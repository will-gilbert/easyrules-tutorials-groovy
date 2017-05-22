package org.jeasy.groovy.tutorials.fire.rules

import org.jeasy.rules.annotation.Action
import org.jeasy.rules.annotation.Condition
import org.jeasy.rules.annotation.Fact
import org.jeasy.rules.annotation.Rule
import org.jeasy.rules.annotation.Priority

import org.jeasy.rules.api.Facts;

@Rule(description='No alarm, nothing to see here; This need to be last rule considered')
class EverythingOKRule {

    @Condition
    boolean when( Facts facts ) {
        facts['alarm'] == null
    }

    @Action
    void then() { 
    	println 'At the Fire Station: Everything is OK' 
    }

    @Priority
    int getPriority() { 15 }

}
