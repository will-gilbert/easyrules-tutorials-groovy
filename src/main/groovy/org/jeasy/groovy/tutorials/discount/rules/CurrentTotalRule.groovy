package org.jeasy.groovy.tutorials.discount.rules


import org.jeasy.rules.annotation.Action
import org.jeasy.rules.annotation.Condition
import org.jeasy.rules.annotation.Fact
import org.jeasy.rules.annotation.Rule
import org.jeasy.rules.annotation.Priority

import org.jeasy.rules.api.Facts;

@Rule
class CurrentTotalRule {

    @Condition
    boolean when( @Fact('customer') customer ) {
        customer.total > 0.0
    }

    @Action
    void then( @Fact('customer') customer ) { 
        def total = customer.total
        def discount = (customer.discount as double)/100
        def cost = total - (total * discount) 

        print "$customer.name has bought \$$total worth of merchandise"

        if(discount)
            print ", and with a ${customer.discount}% discount"

        println ", the final cost is \$$cost"
    }

    @Priority
    int getPriority() { 20 }

}
