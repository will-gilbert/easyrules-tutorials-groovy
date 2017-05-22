package org.jeasy.groovy.tutorials.fire.rules

import org.jeasy.rules.annotation.Action
import org.jeasy.rules.annotation.Condition
import org.jeasy.rules.annotation.Fact
import org.jeasy.rules.annotation.Rule
import org.jeasy.rules.annotation.Priority

import org.jeasy.rules.api.Facts;

@Rule(description='The fires are out, turn off all of the sprinklers')
class TurnSprinklerOffRule {

    @Condition
    boolean when( @Fact('fires') fires  ) {
        fires.size() == 0
    }

    @Action
    void then(@Fact('sprinklers') sprinklers) { 
        sprinklers.each { sprinkler ->
            if(sprinkler.on) {
               sprinkler.on = false
    	       println "Turn sprinkler off in room: ${sprinkler.room.name}"
            }
        }
    }

    @Priority
    int getPriority() { 0 }

}
