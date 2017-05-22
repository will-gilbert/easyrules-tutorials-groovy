package org.jeasy.groovy.tutorials.fire.rules

import org.jeasy.rules.annotation.Action
import org.jeasy.rules.annotation.Condition
import org.jeasy.rules.annotation.Fact
import org.jeasy.rules.annotation.Rule
import org.jeasy.rules.annotation.Priority

import org.jeasy.rules.api.Facts;

@Rule(description='A fire has been detected in a room, turn on the sprinkler in the room; Highest priority rule')
class TurnSprinklerOnRule {

    @Condition
    boolean when( @Fact('fires') fires ) {
        fires.size() > 0
    }

    @Action
    void then( Facts facts ) { 
        
        facts['fires'].each { fire ->

            def sprinkler = facts['sprinklers'].find { sprinkler ->
                sprinkler.room.name == fire.room.name
            }

            if(sprinkler) {
               sprinkler.on = true
    	       println "Turn sprinkler on in room: ${sprinkler.room.name}"
            }
        }
    }

    @Priority
    int getPriority() { 0 }

}
