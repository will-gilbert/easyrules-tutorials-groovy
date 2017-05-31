package org.jeasy.groovy.tutorials.honestpolitician.rules

import org.jeasy.rules.annotation.Action
import org.jeasy.rules.annotation.Condition
import org.jeasy.rules.annotation.Fact
import org.jeasy.rules.annotation.Rule
import org.jeasy.rules.annotation.Priority

import org.jeasy.rules.api.Facts;

@Rule
class CorruptRule {

    @Condition
    boolean when( @Fact('politicians' ) politicians ) {
        politicians.any { it.honest } 
    }

    @Action
    void then( @Fact('politicians' ) politicians ) {

        // Get an honest politician
        def politician = politicians.find { it.honest }

        // Corrupt them
        politician.honest = false
        println "   I'm an evil corporation and I have corrupted the $politician.name"
    }

    @Priority
    int getPriority() { 5 }

}
