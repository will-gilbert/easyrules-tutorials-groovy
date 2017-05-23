package org.jeasy.groovy.tutorials.discount.rules


import org.jeasy.rules.annotation.Action
import org.jeasy.rules.annotation.Condition
import org.jeasy.rules.annotation.Fact
import org.jeasy.rules.annotation.Rule
import org.jeasy.rules.annotation.Priority

import org.jeasy.rules.api.Facts;

@Rule(description='No alarm, nothing to see here; This need to be last rule considered')
class PurchaseRule {

    @Condition
    boolean when( Facts facts ) {
        facts['purchase']
    }

    @Action
    void then( Facts facts ) { 
        def purchase = facts['purchase']
        def customer = facts['customer']
        def product = facts[purchase]

        customer.total += product.price
        def cost = customer.total

        println "$customer.name bought $product.name for \$${product.price}"
        facts.remove('purchase') 
    }

    @Priority
    int getPriority() { 1 }

}
