package org.jeasy.groovy.tutorials.helloworld

import org.jeasy.rules.annotation.Action
import org.jeasy.rules.annotation.Condition
import org.jeasy.rules.annotation.Fact
import org.jeasy.rules.annotation.Rule

@Rule(name = "Hello World rule", description = "Say Hello to duke's friends only")
class HelloWorldRule {


    // The rule should be applied only if the user's response is yes (Duke's friend)
    @Condition
    boolean when( @Fact('input') input ) { 
        input.equalsIgnoreCase 'yes' 
    }


    // When rule conditions are satisfied, print 'Hello duke's friend!' to the console
    @Action
    void then() { 
        println 'Hello Duke\'s friend!' 
    }

}
