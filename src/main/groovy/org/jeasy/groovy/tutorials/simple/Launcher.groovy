package org.jeasy.groovy.tutorials.simple

import org.jeasy.rules.api.Facts
import org.jeasy.rules.api.Rules
import org.jeasy.rules.api.RulesEngine
import org.jeasy.rules.core.DefaultRulesEngine

class Launcher {

    static void main(String... args) {

        def label = 'FIRE A BASIC RULE'.replaceAll(/./){it+' '}
        def width = 80

        println """${'='*width}
                  |${label.center width }
                  |${'='*width}""".stripMargin()

        // Create Facts
        Facts facts = new Facts();

        // Create Rules
        Rules rules = new Rules();
        rules.register(new SimpleRule())

        // Create a rules engine
        RulesEngine rulesEngine = new DefaultRulesEngine()

        // Fire rules
        rulesEngine.fire(rules, facts)
    }

}
