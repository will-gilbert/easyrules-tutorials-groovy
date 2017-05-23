package org.jeasy.groovy.tutorials.discount.rules


import org.jeasy.rules.annotation.Action
import org.jeasy.rules.annotation.Condition
import org.jeasy.rules.annotation.Fact
import org.jeasy.rules.annotation.Rule
import org.jeasy.rules.annotation.Priority

import org.jeasy.rules.api.Facts;

@Rule
class ApplyDiscountRule {

    static final DISCOUNT = 10

    @Condition
    boolean when( @Fact('customer') customer ) {
        customer.total >= 100.0
    }

    @Action
    void then( @Fact('customer') customer) { 
        customer.discount = DISCOUNT
    }

    @Priority
    int getPriority() { 10 }

}
