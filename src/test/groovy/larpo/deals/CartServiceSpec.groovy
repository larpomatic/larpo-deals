package larpo.deals

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

import java.lang.reflect.Array

class CartServiceSpec extends Specification implements ServiceUnitTest<CartService> {


    void "test null cart"() {
        given:
        Cart cart = null
        when:
        Integer res = CartService.cost(cart)
        then:
        res == 0
    }

    void "test empty cart"() {
        given:
        Cart cart = new Cart("test", new Date(), [])
        when:
        Integer res = CartService.cost(cart)
        then:
        res == 0
    }

    void "test cart 1 element"() {
        given:
        Deal dealCost5 = new Deal("", "", "", 5)
        Cart cart = new Cart("test", new Date(), [dealCost5])
        when:
        Integer res = CartService.cost(cart)
        then:
        res == 5
    }

    void "test cart 2 element"() {
        given:
        Deal dealCost5 = new Deal("", "", "", 5)
        Deal dealCost2 = new Deal("", "", "", 2)
        Cart cart = new Cart("test", new Date(), [dealCost5, dealCost2])
        when:
        Integer res = CartService.cost(cart)
        then:
        res == 7
    }

    void "test cart 5 element"() {
        given:
        Deal dealCost1 = new Deal("", "", "", 1)
        Deal dealCost2 = new Deal("", "", "", 2)
        Deal dealCost3 = new Deal("", "", "", 3)
        Deal dealCost4 = new Deal("", "", "", 4)
        Deal dealCost5 = new Deal("", "", "", 5)
        Cart cart = new Cart("test", new Date(), [dealCost1, dealCost2, dealCost3, dealCost4, dealCost5])
        when:
        Integer res = CartService.cost(cart)
        then:
        res == 15
    }

    void "test cart 10 element"() {
        given:
        List list = []
        for (i in 0..<5) {
            list.add(new Deal("", "", "", 2))
            list.add(new Deal("", "", "", 5))
        }
        Cart cart = new Cart("test", new Date(), list)
        when:
        Integer res = CartService.cost(cart)
        then:
        res == 35
    }

    void "test cart 100 element"() {
        given:
        List list = []
        for (i in 0..<50) {
            list.add(new Deal("", "", "", 2))
            list.add(new Deal("", "", "", 5))
        }
        Cart cart = new Cart("test", new Date(), list)
        when:
        Integer res = CartService.cost(cart)
        then:
        res == 350
    }
}
