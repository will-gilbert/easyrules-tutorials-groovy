package org.jeasy.groovy.tutorials.fizzbuzz

import org.jeasy.rules.core.CompositeRule;

class FizzBuzzRule extends CompositeRule {

    FizzBuzzRule(Object... rules) {
    	rules.each {  addRule it  }
    }

    @Override
    int getPriority() { 0 }
}
