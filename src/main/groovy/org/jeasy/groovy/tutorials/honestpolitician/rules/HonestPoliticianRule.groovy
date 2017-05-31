package org.jeasy.groovy.tutorials.honestpolitician.rules

import org.jeasy.rules.annotation.Action
import org.jeasy.rules.annotation.Condition
import org.jeasy.rules.annotation.Fact
import org.jeasy.rules.annotation.Rule
import org.jeasy.rules.annotation.Priority

import org.jeasy.rules.api.Facts;

@Rule
class HonestPoliticianRule {

    @Condition
    boolean when( Facts facts ) {
        facts['politicians'].any { it.honest }
    }

    @Action
    void then( Facts facts) {
        facts.put 'hope', new String("Hope!")
    }

    @Priority
    int getPriority() { 2 }

}
