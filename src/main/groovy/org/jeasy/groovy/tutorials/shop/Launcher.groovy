package org.jeasy.groovy.tutorials.shop

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;

import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.mvel.MVELRuleFactory

import java.time.LocalTime;

class Launcher {

    static void main(String... args) {

        println "${'='*90}"
        println '     S H O P   W I T H   E A S Y   R U L E S '
        println "${'='*90}"


        String name = args?.size()>0 ? args[0] ?: "Tom" : "Tom"
        int age = args?.size() > 1 ? args[1] as int ?: 16 : 16
        LocalTime time = args?.size() > 2 ? LocalTime.parse(args[2]) ?: LocalTime.of(23, 30) : LocalTime.of(23, 30)

        // Create a person instance based on input
        def person = new Person(name:/*args[0]*/name, age:/*args[1] as int*/age)
        println "$person.name($person.age): Hi! can I have some Vodka please?"

        // Create Facts and add the person
        def facts = new Facts()
        facts.put 'person',person
        facts.put 'time', time

        // Create Rules
        def rules = new Rules()

        // Adult Age Rule
        rules.register new MVELRule()
                .name('age rule')
                .description('Check if person\'s age is > 18 and marks the person as adult')
                .priority(1)
                .when('person.age > 18 && time.isBefore(java.time.LocalTime.of(21, 0))')
                .then('person.setAdult(true); System.out.println(person.name + " is adult");')
 
        // Alcohol Sale Rule
        rules.register MVELRuleFactory.createRuleFrom(new File('src/main/resources/alcohol-rule.yml'));


        // Create a rules engine
        def rulesEngine = new DefaultRulesEngine()

        // Fire rules
        rulesEngine.fire rules, facts
    }

}
