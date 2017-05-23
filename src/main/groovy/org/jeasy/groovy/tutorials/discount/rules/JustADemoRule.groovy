package org.jeasy.groovy.tutorials.discount.rules


import org.jeasy.rules.annotation.Action
import org.jeasy.rules.annotation.Condition
import org.jeasy.rules.annotation.Fact
import org.jeasy.rules.annotation.Rule
import org.jeasy.rules.annotation.Priority

import org.jeasy.rules.api.Facts;

@Rule
class JustADemoRule {

    @Condition
    boolean when( @Fact('customer') customer ) {
        customer.total < 0.0
    }

    @Action
    void then( @Fact('customer') customer ) { 
        println "I know that \$$customer.total is not realistic! But hey, it's just a stupid demo!"
    }

    @Priority
    int getPriority() { 20 }

}
