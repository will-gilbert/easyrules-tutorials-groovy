package org.jeasy.groovy.tutorials.complex

import org.jeasy.rules.api.Facts
import org.jeasy.rules.api.Rules
import org.jeasy.rules.core.DefaultRulesEngine
import org.jeasy.rules.mvel.MVELRule
import org.jeasy.rules.support.UnitRuleGroup

import java.awt.Color

class ComplexTest {

    static void main(String... args) {
        // Prepare common objects
        Product samsungBlack = new Product(brand: 'Samsung', color: Color.BLACK)
        Product iphoneWhite  = new Product(brand: 'IPhone', color: Color.WHITE)
        Customer customer = new Customer(name: 'John Dow')

        Order order = new Order(customer: customer, items: [
                new OrderItem(product: samsungBlack, quantity: 1, price: 800.0, amount: 1*800.0),
                new OrderItem(product: iphoneWhite, quantity: 2, price:900.0, amount: 2*900.0)
        ])

        // Create complex Rules
        def rules = new Rules()

        // Create rule: if order item contains Samsung or HTC product brand - add points (should match)
        // It seems to implement OR condition, we have to make two separate although very similar rules
        // We also could implement OR condition in 'when' block using java || operator
        rules.register new MVELRule()
                .name('Samsung or HTC brand rule')
                .description('Check if product brand is Samsung or HTC')
                .priority(1)
                .when('item.product.brand.equalsIgnoreCase("SAMSUNG") || item.product.brand.equalsIgnoreCase("HTC")')
                .then('customer.addPoints(Util.amountToPoins(item.amount)); System.out.println(customer + " got "+Util.amountToPoins(item.amount)+" points");')

        // Create rule: if order item contains IPhone black - add points (should not match: color does not match)
        // do it using composite rule:

        UnitRuleGroup ruleGroupIPhoneBlack = new UnitRuleGroup("Black IPhone rule unit")

        ruleGroupIPhoneBlack.addRule(new MVELRule()
                .name('Product brand IPhone rule')
                .description('Check if product brand is IPhone')
                .priority(1)
                .when('item.product.brand.equalsIgnoreCase("IPHONE")')
        )

        ruleGroupIPhoneBlack.addRule(new MVELRule()
                .name('Product color is BLACK')
                .description('Check if product color is BLACK')
                .priority(1)
                .when('item.product.color == java.awt.Color.BLACK')
                .then('customer.addPoints(Util.amountToPoins(item.amount)); System.out.println(customer + " got "+Util.amountToPoins(item.amount)+" points");')
        )


        rules.register ruleGroupIPhoneBlack

        // create additional rule, assuming we have read rule conditions from some external source f.e. DB
        String ruleName = 'Product brand is IPhone OR product color is green'
        String ruleDescription = 'Rule conditions are read from external source'
        int rulePriority = 2
        String[] ruleConditions = [
                'item.product.brand.equalsIgnoreCase("IPHONE")',
                'item.product.color == java.awt.Color.GREEN'
        ]
        String ruleGroupModifier = '||'
        String[] ruleActions = [
                'customer.addPoints(Util.amountToPoins(item.amount))',
                'System.out.println(customer + " got "+Util.amountToPoins(item.amount)+" points")'
        ]
        String ruleActionsModifier = ';'

        rules.register(new MVELRule()
                .name(ruleName)
                .description(ruleDescription)
                .priority(rulePriority)
                .when(ruleConditions.join(ruleGroupModifier))
                .then(ruleActions.join(ruleActionsModifier)+ruleActionsModifier)
        )

        //  Create facts
        // Create Facts and add the person
        def facts = new Facts()
        facts.put 'customer', customer
        facts.put 'Util', Util.class

        // Create a rules engine
        def rulesEngine = new DefaultRulesEngine()

        println "Starting..."
        // Fire rules for each order item
        for (OrderItem item: order.items) {
            facts.put 'item', item
            rulesEngine.fire rules, facts
        }
        println "Done"
    }
}
