package org.jeasy.groovy.tutorials.fizzbuzz

import org.jeasy.rules.annotation.Action
import org.jeasy.rules.annotation.Condition
import org.jeasy.rules.annotation.Rule
import org.jeasy.rules.annotation.Fact
import org.jeasy.rules.annotation.Priority

@Rule
class BuzzRule {

    def input

    @Condition
    boolean when(@Fact('number') Integer number) { 
        number % 5 == 0 
    }

    @Action
    public void then() { print 'buzz' }

    @Priority
    int getPriority() { 2 }
}
