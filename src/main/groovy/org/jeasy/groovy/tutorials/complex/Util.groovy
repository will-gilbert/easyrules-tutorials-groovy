package org.jeasy.groovy.tutorials.complex

class Util {

    static long amountToPoins(final double points) {
        Math.floor(points + 0.5).longValue()
    }
}
