package org.jeasy.groovy.tutorials.simple

import org.jeasy.rules.annotation.Action
import org.jeasy.rules.annotation.Condition
import org.jeasy.rules.annotation.Rule

@Rule
public class SimpleRule  {

    @Condition
    public boolean when() { true }

    @Action
    public void then() { println "Easy Rules rocks!" }
    
}
