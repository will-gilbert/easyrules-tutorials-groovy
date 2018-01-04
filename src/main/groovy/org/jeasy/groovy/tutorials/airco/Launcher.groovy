package org.jeasy.groovy.tutorials.airco;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.InferenceRulesEngine;
import org.jeasy.rules.core.RuleBuilder;

import static org.jeasy.groovy.tutorials.airco.DecreaseTemperatureAction.decreaseTemperature;
import static org.jeasy.groovy.tutorials.airco.HighTemperatureCondition.itIsHot;

public class Launcher {

    public static void main(String[] args) {

        def label = 'AIR CONDITIONING DEMO'.replaceAll(/./){it+' '}
        def width = 80

        println """${'='*width}
                  |${label.center width }
                  |${'='*width}""".stripMargin()

        // The current temperature and the target temperature
        def current = args[0] as int
        def target = args[1] as int

        // Define facts
        Facts facts = new Facts();
        facts.put("temperature", current);
        facts.put("target", target);

        // define rules
        Rule airConditioningRule = new RuleBuilder()
                .name("air conditioning rule")
                .when(itIsHot())
                .then(decreaseTemperature())
                .build();
        Rules rules = new Rules();
        rules.register(airConditioningRule);

        // fire rules on known facts
        RulesEngine rulesEngine = new InferenceRulesEngine();
        rulesEngine.fire(rules, facts);

        println "Ahhh, it's now ${facts.get("temperature")}; Much cooler!!!"
    }

}