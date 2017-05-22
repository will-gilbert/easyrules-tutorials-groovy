package org.jeasy.groovy.tutorials.fizzbuzz

import org.jeasy.rules.annotation.Action
import org.jeasy.rules.annotation.Condition
import org.jeasy.rules.annotation.Rule
import org.jeasy.rules.annotation.Fact
import org.jeasy.rules.annotation.Priority

@Rule
class FizzRule {

    @Condition
    boolean when(@Fact('number') Integer number) { 
        number % 3 == 0 
    }

    @Action
    public void then() { print 'fizz' }

    @Priority
    int getPriority() { 1 }
}
