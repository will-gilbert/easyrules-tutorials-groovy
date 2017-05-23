# EasyRules Tutorials Groovy

EasyRules tutorials using Groovy beans with a Gradle build script.


## Based on [Easy Rules](https://github.com/j-easy/easy-rules/wiki) and the [Java/Maven Tutorials](https://github.com/j-easy/easy-rules/tree/master/easy-rules-tutorials)

### Usage:

NB: Use '--quiet' or '-q' to supress Gradle build output lines

    ./gradlew usage
       Prints the following usage to the console

    ./gradlew FizzBuzz
       Baseline FizzBuzz using code. (From: http://wiki.c2.com/?FizzBuzzTest)
       Prints the integers from 1 to 100.  For multiples of 3, print 'Fizz' instead 
       of the integer and for the multiples of 5, print 'Buzz'. For integers which are 
       multiples of both 3 and 5, print 'FizzBuzz'.
       
    ./gradlew FizzBuzzER
       FizzBuzz implementation using EasyRules.
       
    ./gradlew Simple
       Very simple EasyRules examples with one, always true, rule.
       
    ./gradlew HelloWorld -q
       Obligatory 'Hello, world' example where the input is evaluated by a rule.
       
    ./gradlew Shop -P person=Tommy -P age=15
       Rule to evaluate drinking age (US 21); Nmae and age can be passed in via the command line
       or system properties; Default is 'Tom' at age '17'.

    ./gradlew Fire -q
        Copied from DROOLS examples. Create some rooms with sprinklers, start some fires.
        The sprinklers will turn on and an alarm will be raised to notify the Fire Department.
        Put out the fires, the sprinklers will turn off and the alarm will be silenced.
              
    ./gradlew clean
     Remove all reports and artifacts from './build'

Windows Users - use ```gradlew``` instead of ```./gradlew``` to run each tutorial.
