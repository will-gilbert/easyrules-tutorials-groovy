package org.jeasy.groovy.tutorials.honestpolitician.rules


import org.jeasy.groovy.tutorials.honestpolitician.beans.Hope

import org.jeasy.rules.annotation.Action
import org.jeasy.rules.annotation.Condition
import org.jeasy.rules.annotation.Fact
import org.jeasy.rules.annotation.Rule
import org.jeasy.rules.annotation.Priority

import org.jeasy.rules.api.Facts;

@Rule
class RejoiceRule {

    @Condition
    boolean when( Facts facts ) {
        facts['hope']
    }

    @Action
    void then() {
        println '   We have hope. Democracy Lives.'
    }

    @Priority
    int getPriority() { 2 }

}
