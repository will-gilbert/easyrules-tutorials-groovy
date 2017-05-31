package org.jeasy.groovy.tutorials.honestpolitician.rules

import org.jeasy.rules.annotation.Action
import org.jeasy.rules.annotation.Condition
import org.jeasy.rules.annotation.Fact
import org.jeasy.rules.annotation.Rule
import org.jeasy.rules.annotation.Priority

import org.jeasy.rules.api.Facts;

@Rule
class NoHonestPoliticianRule {

    @Condition
    boolean when( Facts facts ) {
        facts['politicians'].any { it.honest } == false
    }

    @Action
    void then( Facts facts) {
        facts.remove 'hope'
    }

    @Priority
    int getPriority() { 1 }

}
