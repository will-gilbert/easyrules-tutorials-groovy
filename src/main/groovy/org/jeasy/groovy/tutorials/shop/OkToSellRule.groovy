package org.jeasy.groovy.tutorials.shop

import org.jeasy.rules.core.BasicRule;
import org.jeasy.rules.api.Facts;

class OkToSellRule extends BasicRule {

    OkToSellRule() {
        super('OkToSellRule', 'Adults are allowed to buy alcohol', 2)
    }

    @Override
    boolean evaluate(Facts facts) {
        def person = facts['person']
        person.adult == true
    }

    @Override
    void execute(Facts facts){
        def person = facts['person']
        println "Shop Owner: Ok, $person.name, here you go."
    }

}
