package org.jeasy.groovy.tutorials.shop

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;

import static org.jeasy.rules.core.RulesEngineBuilder.aNewRulesEngine

class Launcher {

    static void main(String... args) {

        println "${'='*90}"
        println '     S H O P   W I T H   E A S Y   R U L E S '
        println "${'='*90}"


        // Create a person instance
        def person = new Person(name:args[0], age: args[1] as int)
        println "$person.name: Hi! can I have some Vodka please?"

        // Create Facts and add the person
        def facts = new Facts();
        facts.add 'person',person

        // Create Rules
        def rules = new Rules()
        rules.register new AgeRule()
        rules.register new AlcoholRule()
        rules.register new OkToSellRule()

        // Create a rules engine
        def rulesEngine = aNewRulesEngine()
                .named("shop rules engine")
                .build()

        // Fire rules
        rulesEngine.fire rules, facts
    }

}
