package org.jeasy.groovy.tutorials.honestpolitician

import org.jeasy.groovy.tutorials.honestpolitician.beans.*
import org.jeasy.groovy.tutorials.honestpolitician.rules.*

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.core.DefaultRulesEngine;

import static org.jeasy.rules.core.RulesEngineBuilder.aNewRulesEngine

class Launcher {

    static void main(final String... args) {
        
        def label = 'HONEST POLITICIAN'.replaceAll(/./){it+' '}
        def width = 80

        println """${'='*width}
                  |${label.center width }
                  |${'='*width}""".stripMargin()

        // Create some politicians as facts
        def politicians = []
        politicians << new Politician( 'President of Umpa Lumpa' )
        politicians << new Politician( 'Prime Minster of Cheeseland' )
        politicians << new Politician( 'Tsar of Pringapopaloo' )
        politicians << new Politician( 'Omnipotence Om' )

        def facts = new Facts()
        facts.put 'politicians',politicians


        // Create the rules engine
        def rulesEngine = new DefaultRulesEngine()

        // Create and register the initial state of rules
        def rules = new Rules()
        rules.register new HonestPoliticianRule()
        rules.register new NoHonestPoliticianRule()
        rules.register new RejoiceRule()
        rules.register new LamentRule()

        println 'We have honest politicians.'
        rulesEngine.fire rules,facts

        println '\nIntroduce big corporations which will corrupt each politician.'
        rules.register new CorruptRule()

        // Corrupt each politician
        while( politicians.any{it.honest} ) {
            rulesEngine.fire rules,facts
        }

        println '\nNow that there are no honest politicians.'
        rulesEngine.fire rules,facts

    }

}
