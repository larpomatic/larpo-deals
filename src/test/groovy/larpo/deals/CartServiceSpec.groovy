package larpo.deals

import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class CartServiceSpec extends Specification implements ServiceUnitTest<CartService>, DataTest{

    def setup() {
        new Deal("testDealCaption", "testDeal", "testDealDescription", 10).save(failOnError: true)
        new Deal("testDealCaption", "testDeal", "testDealDescription", 100).save(failOnError: true)
        new Deal("testDealCaption", "testDeal", "testDealDescription", 1000).save(failOnError: true)
    }

    def cleanup() {
    }

    @Override
    Class[] getDomainClassesToMock() {
        return [Deal, Cart]
    }

    void "test cost of null cart"() {
        given: Cart cart = null
        when: Integer cost = service.cost(cart)
        then: cost == 0
    }

    void "test cost cart containing 3 deals"() {
        given: Cart cart = new Cart("testCartName", new Date())
            for (deal in Deal.list()){
                cart.addToDeals(deal)
            }
            Integer[] nbDeals = [0, 1, 1, 1]
            cart.setLutNbDeals(nbDeals)
        when: Integer cost = service.cost(cart)
        then: cost == 1110
    }

    void "test cost cart containing several times the same deal"() {
        given: Cart cart = new Cart("testCartName", new Date())
            cart.addToDeals(Deal.list()[2])
            cart.addToDeals(Deal.list()[2])
            cart.addToDeals(Deal.list()[2])
            Integer[] nbDeals = [0, 0, 0, 3]
            cart.setLutNbDeals(nbDeals)
        when: Integer cost = service.cost(cart)
        then: cost == 1000 * 3
    }

    void "test getNbDeals null cart"(){
        given: Cart cart = null
        when: Integer nbDeals = service.getNbDeals(cart)
        then: nbDeals == 0
    }

    void "test getNbDeals cart containing 3 different deals"(){
        given: Cart cart = new Cart("testCartName", new Date())
            for (deal in Deal.list()){
                cart.addToDeals(deal)
            }
            Integer[] lutNbDeals = [0, 1, 1, 1]
            cart.setLutNbDeals(lutNbDeals)
        when: Integer nbDeals = service.getNbDeals(cart)
        then: nbDeals == 3
    }

    void "test getNbDeals cart containing 3 different deals multiple times"(){
        given: Cart cart = new Cart("testCartName", new Date())
        for (deal in Deal.list()){
            cart.addToDeals(deal)
        }
        Integer[] lutNbDeals = [0, 13, 25, 35]
        cart.setLutNbDeals(lutNbDeals)
        when: Integer nbDeals = service.getNbDeals(cart)
        then: nbDeals == 13 + 25 + 35
    }
}
