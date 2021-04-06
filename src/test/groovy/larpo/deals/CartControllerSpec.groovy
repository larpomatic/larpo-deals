package larpo.deals

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class CartControllerSpec extends Specification implements ControllerUnitTest<CartController>, DataTest {

    @Override
    Class[] getDomainClassesToMock() {
        // Liste des domains utiliser par le controller
        return [Deal, Cart]
    }


    def cleanup() {
    }

    void "list cart empty session cart"() {
        given:
        Deal truck = new Deal("", "", "", 1)
        Deal Bus1 = new Deal("", "", "", 2)
        Deal Bus2 = new Deal("", "", "", 3)
        new Cart("lovely train", new Date(), [truck, Bus1]).save(failOnError: true)
        new Cart("tin tin tin", new Date(), [Bus2]).save(failOnError: true)
        when:
        def res = controller.list()
        then:
        res.size() == 2
    }


    void "list cart with session cart"() {
        given:
        Deal truck = new Deal("", "", "", 1)
        Deal Bus1 = new Deal("", "", "", 2)
        Deal Bus2 = new Deal("", "", "", 3)
        new Cart("lovely train", new Date(), [truck, Bus1]).save(failOnError: true)
        new Cart("tin tin tin", new Date(), [Bus2]).save(failOnError: true)
        session.cart = new Cart("Session cart", new Date(), [])
        when:
        def res = controller.list()
        then:
        res.size() == 2
    }


    void "add deal to cart already in cart"() {
        given:
        Deal truck = new Deal("", "", "", 1).save(failOnError: true)
        Deal Bus1 = new Deal("", "", "", 2).save(failOnError: true)
        session.cart = new Cart("Session cart", new Date(), [truck, Bus1])
        when:
        params.dealToAdd = Bus1.id.toString()
        controller.addDealToCart()
        then:
        session.cart.deals.size() == 2

    }

    void "save null cart"() {
        given:

        when:
        controller.SaveCart()
        def res = Cart.list()
        then:
        res.size() == 0
    }

    void "save cart"() {
        given:
        session.cart = new Cart("Session cart", new Date(), [])
        when:
        controller.SaveCart()
        def res = Cart.list()
        then:
        res.size() == 1
        session.cart == null
    }


}
