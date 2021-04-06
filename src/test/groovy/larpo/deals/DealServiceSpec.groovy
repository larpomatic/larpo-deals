package larpo.deals

import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class DealServiceSpec extends Specification implements ServiceUnitTest<DealService>, DataTest{

    def setup() {
        BootStrap bootStrap = new BootStrap()
        bootStrap.init()
    }

    def cleanup() {
    }

    @Override
    Class[] getDomainClassesToMock() {
        return [Deal, Cart]
    }

    void "test getDealsSorted empty cart"() {
        given: Cart cart = null
        when: Deal[] deals = service.getDealsSorted(cart)
        then: deals.size() == 0
    }

    void "test getDealsSorted cart with unsorted deals"() {
        given: Cart cart = new Cart("current cart", new Date())
            cart.addToDeals(Deal.list()[0])
            cart.addToDeals(Deal.list()[1])
            cart.addToDeals(Deal.list()[2])
            cart.setLutNbDeals([0, 2, 8, 4] as Integer[])
        when: Deal[] deals = service.getDealsSorted(cart)
        then: deals.size() == 3
            deals[0].id == 2
            deals[1].id == 3
            deals[2].id == 1
    }

    void "test getDealsSorted cart with unsorted deals names"() {
        given: Cart cart = new Cart("current cart", new Date())
        cart.addToDeals(Deal.list()[0])
        cart.addToDeals(Deal.list()[1])
        cart.addToDeals(Deal.list()[2])
        cart.setLutNbDeals([0, 1, 1, 1, 0, 0, 0] as Integer[])
        when: Deal[] deals = service.getDealsSorted(cart)
        then: deals.size() == 3
        deals[0].id == 2
        deals[1].id == 1
        deals[2].id == 3
    }

}
