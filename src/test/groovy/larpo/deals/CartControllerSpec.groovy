package larpo.deals

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class CartControllerSpec extends Specification implements ControllerUnitTest<CartController>, DataTest
{
    @Override
    Class[] getDomainClassesToMock()
    {
        return [Deal, Cart]
    }

    def setupData()
    {
        new BootStrap().init.run()
    }

    def setup()
    {
        setupData()
    }

    def cleanup() {
    }

    /*void "test something"() {
        expect:"fix me"
            true == false
    }*/

    void "initial carts" ()
    {
        when: def res = controller.list()
        then: res.carts.size() == 2
    }

    void "creation cart" ()
    {
        given:
            session["CurrentCart"] = new Cart(new Date(), "Test")
            params.SaveCart = "Test"
        when:
            controller.save(params)
            def res = controller.list()
        then:
            res.carts.size() == 3
    }

    void "Add Deal To Cart" ()
    {
        given: session["CurrentCart"] = new Cart(new Date(), "Test")
        when: controller.addDealToCart(1)
        then: session.CurrentCart.deals.size() == 1
    }
}