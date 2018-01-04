package org.jeasy.groovy.tutorials.shop

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;

import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.mvel.MVELRuleFactory;

class Launcher {

    static void main(String... args) {

        println "${'='*90}"
        println '     S H O P   W I T H   E A S Y   R U L E S '
        println "${'='*90}"


        // Create a person instance based on input
        def person = new Person(name:args[0], age:args[1] as int)
        println "$person.name($person.age): Hi! can I have some Vodka please?"

        // Create Facts and add the person
        def facts = new Facts();
        facts.put 'person',person

        // Create Rules
        def rules = new Rules();

        // Adult Age Rule
        rules.register new MVELRule()
                .name('age rule')
                .description('Check if person\'s age is > 18 and marks the person as adult')
                .priority(1)
                .when('person.age > 18')
                .then('person.setAdult(true);');
 
        // Alcohol Sale Rule
        rules.register MVELRuleFactory.createRuleFrom(new File('src/main/resources/alcohol-rule.yml'));


        // Create a rules engine
        def rulesEngine = new DefaultRulesEngine()

        // Fire rules
        rulesEngine.fire rules, facts
    }

}
