package org.jeasy.groovy.tutorials.helloworld

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import java.util.Scanner

class Launcher {

    static void main(String... args) {

        def label = 'HELLO WORLD EXAMPLE'.replaceAll(/./){it+' '}
        def width = 80

        println """${'='*width}
                  |${label.center width }
                  |${'='*width}""".stripMargin()

        def scanner = new Scanner(System.in)
        print("Are you a friend of Duke? [yes/No]: ")
        def input = scanner.nextLine()

        // Create Facts
        def facts = new Facts()
        facts.add('input', input)

        // Create and register Rules
        def rules = new Rules()
        rules.register(new HelloWorldRule())
    
        def rulesEngine = new DefaultRulesEngine()
        rulesEngine.fire(rules, facts)

    }
}
