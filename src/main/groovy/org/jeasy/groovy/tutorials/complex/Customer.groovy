package org.jeasy.groovy.tutorials.complex

import groovy.transform.ToString

@ToString(includeFields = true)
class Customer {
    String name
    long points

    void addPoints(final long points) {
        this.points += points
    }
}
