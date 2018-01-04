package org.jeasy.groovy.tutorials.fire

import org.jeasy.groovy.tutorials.fire.rules.*
import org.jeasy.groovy.tutorials.fire.beans.*

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.core.DefaultRulesEngine;

class Launcher {

    static void main(String... args) {
        
        def label = 'FIRE ALARM'.replaceAll(/./){it+' '}
        def width = 80

        println """${'='*width}
                  |${label.center width }
                  |${'='*width}""".stripMargin()


        // Define some room names
        def names = ['Kitchen', 'Bedroom', 'Office', 'Livingroom']

        // Create the rooms for each name; Install a sprinkler system in each room
        def rooms = [:]
        def sprinklers = [] 

        names.each { name ->
            rooms[name] = new Room(name)
            sprinklers << new Sprinkler(rooms[name])
        }

        // Create a Facts container; Add sprinkers and an empty list of fires
        def facts = new Facts()    
        facts.put 'sprinklers',sprinklers
        facts.put 'fires',[]

        // Create the rules engine
        def rulesEngine = new DefaultRulesEngine()

        // Create and register all of the rules
        def rules = new Rules()
        rules.register new EverythingOKRule()
        rules.register new RaiseAlarmRule()
        rules.register new CancelAlarmRule()
        rules.register new ThereIsAnAlarmRule()
        rules.register new TurnSprinklerOnRule()
        rules.register new TurnSprinklerOffRule()

        // Fire the rules to get a situation normal
        rulesEngine.fire rules,facts

        // Start some fires and fire the rules
        pause('Start some fires')
        facts['fires'] << new Fire( rooms['Kitchen'] )
        facts['fires'] << new Fire( rooms['Office'] )
        rulesEngine.fire rules, facts

        // Put out the fires and fire the rules
        pause('Put out the fires')
        facts['fires'].clear()
        rulesEngine.fire rules,facts
    }

    public static void pause(message) {
        println "\n>>>>>> Press enter to '$message' <<<<<<"
        def keyboard = new Scanner(System.in)
        keyboard.nextLine()
    }

}
