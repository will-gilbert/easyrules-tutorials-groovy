package org.jeasy.groovy.tutorials.fizzbuzz

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;

//import static org.jeasy.rules.core.RulesEngineBuilder.aNewRulesEngine

 class FizzBuzzWithEasyRules {

    static void main(String... args) {

        def label = 'FIZZBUZZ WITH EASYRULES'.replaceAll(/./){it+' '}
        def width = 80

        println """${'='*width}
                  |${label.center width }
                  |${'='*width}""".stripMargin()

        // Create rules engine
        def fizzBuzzEngine = aNewRulesEngine()
                .withSkipOnFirstAppliedRule(true)
                .withSilentMode(true)
                .build()

        // Create and register rules
        def rules = new Rules()
        rules.register new FizzRule()
        rules.register new BuzzRule()
        rules.register new NonFizzBuzzRule()
        rules.register new FizzBuzzRule(new FizzRule(), new BuzzRule())

        // Create a facts container
        def facts = new Facts();

        // Fire rules
        (1..100).each { number ->
            facts.put 'number', number
            fizzBuzzEngine.fire rules, facts
            println()
        }
    }
}
