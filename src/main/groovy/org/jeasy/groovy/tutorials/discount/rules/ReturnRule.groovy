package org.jeasy.groovy.tutorials.discount.rules

import org.jeasy.groovy.tutorials.discount.beans.*

import org.jeasy.rules.annotation.Action
import org.jeasy.rules.annotation.Condition
import org.jeasy.rules.annotation.Fact
import org.jeasy.rules.annotation.Rule
import org.jeasy.rules.annotation.Priority

import org.jeasy.rules.api.Facts;

@Rule
class ReturnRule {

    @Condition
    boolean when( Facts facts ) {
        facts['return']
    }

    @Action
    void then( Facts facts ) { 
        def customer = facts['customer']
        def item = facts['return']
        def product = facts[item]

        customer.total -= product.price

        println "$customer.name returned $product.name which cost \$${product.price}"
        facts.remove 'return'
    }

    @Priority
    int getPriority() { 1 }

}
