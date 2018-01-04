package org.jeasy.groovy.tutorials.weather

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

public class Launcher {

    public static void main(String[] args) {

        def label = 'WEATHER DEMO'.replaceAll(/./){it+' '}
        def width = 80

        println """${'='*width}
                  |${label.center width }
                  |${'='*width}""".stripMargin()
    
        def isRaining = Boolean.parseBoolean(args[0])

        // Define facts
        def facts = new Facts();
        facts.put "It's raining", isRaining

        // Define rules
        def rules = new Rules();
        rules.register(new WeatherRule())

        // Fire rules on known facts
        new DefaultRulesEngine().fire(rules, facts);
    }

}