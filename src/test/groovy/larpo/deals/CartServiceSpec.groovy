package larpo.deals

import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class CartServiceSpec extends Specification implements ServiceUnitTest<CartService>, DataTest
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

    void "Empty cart cost" ()
    {
        when: Cart res = new Cart()
        then: service.cost(res) == 0
    }

    void "initial lovely cart cost" ()
    {
        expect: service.cost(Cart.list()[0]) == Deal.list()[0].price + Deal.list()[1].price
    }
}