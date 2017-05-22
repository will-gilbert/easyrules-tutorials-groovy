package org.jeasy.groovy.tutorials.fire.beans

@groovy.transform.TupleConstructor
@groovy.transform.EqualsAndHashCode
@groovy.transform.ToString(includePackage = false, includeNames = true)
class Sprinkler {
    def room;
    def on = false;
}
