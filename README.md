# EasyRules Tutorials Groovy

EasyRules tutorials using Groovy beans with a Gradle build script.


## Based on [Easy Rules](https://github.com/j-easy/easy-rules/wiki) and the [Java/Maven Tutorials](https://github.com/j-easy/easy-rules/tree/master/easy-rules-tutorials)

### Usage:

NB: Use then terminal command 'TERM=dumb' OR '--console=plain' along  
    with  '--quiet' or '-q' to suppress Gradle build output lines.

### ./gradlew usage
 
    Prints the following usage to the console

### ./gradlew FizzBuzz
 
    Baseline FizzBuzz using code. (From: http://wiki.c2.com/?FizzBuzzTest)
    Prints the integers from 1 to 100.  For multiples of 3, print 'Fizz' instead 
    of the integer and for the multiples of 5, print 'Buzz'. For integers which are 
    multiples of both 3 and 5, print 'FizzBuzz'.
    
###  ./gradlew FizzBuzzER
 
    FizzBuzz implementation using EasyRules.
    
###  ./gradlew Simple
 
    Very simple EasyRules examples with one, always true, rule.
    
###  ./gradlew HelloWorld --quiet --console=plain
 
    Obligatory 'Hello, world' example where the input is evaluated by a rule.
    
###  ./gradlew Shop -P person=Tommy -P age=15 --quiet --console=plain
 
    Rule to evaluate drinking age (US 21); Name and age can be passed in via the command line
    or system properties; Default is 'Tom' at age '17'.

###  ./gradlew Fire --quiet --console=plain
 
    Copied from DROOLS examples. Create some rooms with sprinklers, start some fires.
    The sprinklers will turn on and an alarm will be raised to notify the Fire Department.
    Put out the fires, the sprinklers will turn off and the alarm will be silenced.
 
###  ./gradlew Discount -P transactions=5 --quiet --console=plain
 
    Copied from DROOLS examples. A customer selects and returns various items. A discount
    is applied or removed depending on the merchandise total at the end of each transaction. 
    Transactions are generated randomly.

### ./gradlew HonestPolitician
 
    Initialize with honest politicians and the people rejoice. Introduce big corporations
    and corrupt each politician.  How the people feel now?

### ./gradlew Weather -P isRaining=true --quiet --console=plain

### ./gradlew AirCo -P current=30  -P target=25 --quiet --console=plain
 
    Nice demo of the new 'InferenceRulesEngine'

### ./gradlew clean
 
  Remove all reports and artifacts from './$project.buildDir.name'

#### Windows Users - use ```gradlew``` instead of ```./gradlew``` to run each tutorial.
