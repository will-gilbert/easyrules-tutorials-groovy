package org.jeasy.groovy.tutorials.discount

import org.jeasy.groovy.tutorials.discount.beans.*
import org.jeasy.groovy.tutorials.discount.rules.*

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.core.DefaultRulesEngine;

class Launcher {

    static final void main(String... args) {
        
        def label = 'DISCOUNT DEMO'.replaceAll(/./){it+' '}
        def width = 80

        println """${'='*width}
                  |${label.center width }
                  |${'='*width}""".stripMargin()
        
        // Create a customer and some shopping items; Add them as facts
        def facts = new Facts()    
        facts.put 'customer', new Customer( 'Mark')
        facts.put 'shoes', new Product( name:'a pair of shoes', price:60 )
        facts.put 'hat', new Product( name:'a hat', price:40 )
        facts.put 'pants', new Product( name:'a pair of pants', price:120 )


        // Create the rules engine
        def rulesEngine = new DefaultRulesEngine()

        // Create and register all of the rules
        def rules = new Rules()
        rules.register new PurchaseRule()
        rules.register new ApplyDiscountRule()
        rules.register new ReturnRule()
        rules.register new RemoveDiscountRule()
        rules.register new CurrentTotalRule()
        rules.register new JustADemoRule()

        // Customer buys or returns some items
        (args[0] as int).times {

            def action = randomAction()
            def item = randomPurchase()

            pause "$action $item"
            facts.put action,item
            rulesEngine.fire rules,facts
        }
  }
 
    public static void pause(message) {
        println "\n>>>>>> Press enter to '$message' <<<<<<"
        def keyboard = new Scanner(System.in)
        keyboard.nextLine()
    }

    public static String randomPurchase() {
        def items = ['shoes', 'hat', 'pants']
        return items[(new Random().nextInt() % items.size())]
    }

    public static String randomAction() {
        def actions = ['purchase', 'purchase', 'return']
        return actions[(new Random().nextInt() % actions.size())]
    }

     
}
