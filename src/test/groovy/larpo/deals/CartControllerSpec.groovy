package larpo.deals

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class CartControllerSpec extends Specification implements ControllerUnitTest<CartController>, DataTest {

    def setup() {
        BootStrap bootStrap = new BootStrap()
        bootStrap.init()
        session['currentCart'] = null
    }

    def cleanup() {
    }

    @Override
    Class[] getDomainClassesToMock() {
        return [Deal, Cart]
    }

    void "test addDealToCart with id that does not exist"() {
        given: params.dealId = 10
        when: controller.addDealToCart()
        then: ArrayIndexOutOfBoundsException exception = thrown()
            exception.message == "This dealId does not exist: 10"
    }

    void "test addDealToCart with normal id"() {
        given: params.dealId = 1
        when: controller.addDealToCart()
            Cart currentCart = session["currentCart"] as Cart
        then: currentCart.getDeals().size() == 1
            currentCart.getDeals()[0] == Deal.list()[0]
    }

    void "test getDeal with id that does not exists"(){
        given: Long dealId = 0
        when: controller.getDeal(dealId)
        then: ArrayIndexOutOfBoundsException exception = thrown()
            exception.message == "This dealId does not exist: 0"
    }

    void "test getDeal with normal id"(){
        given: Long dealId = 3
        when: Deal deal = controller.getDeal(dealId)
        then: deal == Deal.list()[2]
    }

    void "test dealInCart with id that is not in cart"(){
        given: Long dealId = 2
        when: Boolean isDealInCart = controller.dealInCart(dealId)
        then: !isDealInCart
    }

    void "test dealInCart with normal id"(){
        given: Long dealId = 2
            params.dealId = dealId
        when: controller.addDealToCart()
            Boolean isDealInCart = controller.dealInCart(dealId)
        then: isDealInCart
    }

    void "test save cart containing deal 1"(){
        given: session["currentCart"] = new Cart("current cart", new Date())
            session["currentCart"].addToDeals(controller.getDeal(1))
        when: controller.save()
        then: session["currentCart"] == null
            controller.list().carts[2].deals.size() == 1
    }

    void "test save cart containing deal 1 and 3"(){
        given: session["currentCart"] = new Cart("current cart", new Date())
        session["currentCart"].addToDeals(controller.getDeal(1))
        session["currentCart"].addToDeals(controller.getDeal(3))
        when: controller.save()
        then: session["currentCart"] == null
        controller.list().carts[2].deals.size() == 2
    }

    void "test add deal that is already in the cart to cart"(){
        given: session["currentCart"] = new Cart("current cart", new Date())
        session["currentCart"].addToDeals(controller.getDeal(1))
        session["currentCart"].addToDeals(controller.getDeal(3))
        Integer[] lutNbDeals = [0, 1, 0, 1]
        session["currentCart"].setLutNbDeals(lutNbDeals)
        params.dealId = 3
        when: controller.addDealToCart()
        then:
        session["currentCart"].getLutNbDeals()[3] == 2
    }
}
