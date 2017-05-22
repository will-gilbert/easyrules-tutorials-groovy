package org.jeasy.groovy.tutorials.shop

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.core.BasicRule;

public class AgeRule extends BasicRule {

    private static final int ADULT_AGE = 21

    public AgeRule() {
        super('AgeRule', "Check if person's age is $ADULT_AGE or over and marks the person as adult", 1)
    }

    @Override
    public boolean evaluate(Facts facts) {
        def person = facts['person']
        return person.age >= ADULT_AGE
    }

    @Override
    public void execute(Facts facts) {
        def person = facts['person']
        person.adult  = true
        println "Person $person.name has been marked as adult"
    }
    
}
