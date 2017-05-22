package org.jeasy.groovy.tutorials.shop

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.core.BasicRule;

class AlcoholRule extends BasicRule {

    AlcoholRule() {
        super("AlcoholRule", "Children are not allowed to buy alcohol", 2);
    }

    @Override
    boolean evaluate(Facts facts) {
        def person = facts['person']
        !person.isAdult();
    }

    @Override
    void execute(Facts facts){
        def person = facts['person']
        println "Shop Owner: Sorry $person.name, you are not allowed to buy alcohol."
   }

}
