package larpo.deals

import grails.testing.web.controllers.ControllerUnitTest
import grails.testing.gorm.DataTest

import spock.lang.Specification

class CartControllerSpec extends Specification
        implements ControllerUnitTest<CartController>, DataTest  {

    @Override
    Class[] getDomainClassesToMock() {
        // Liste des domains utilisés par le contrôleur
        return [Cart]
    }

    // Methode pour initialiser la BDD
    def setup() {
        Random random = new Random()
        new Deal("http://2.bp.blogspot.com/-O8H8VwjsgHQ/UTSApHY3M_I/AAAAAAAAAhU/AlSeJgJ3ijE/s400/monster-motorbike-1-big.jpg", "Truck", "loremIpsum", random.nextInt(10000)).save(failOnError: true)
        new Deal("http://4.bp.blogspot.com/-Van_nK7u00s/UVxQXKZvJJI/AAAAAAAABdg/NzAitf6enl4/s1600/21e004.jpg", "Bus", "loremIpsum", random.nextInt(10000)).save(failOnError: true)
        new Deal("http://4.bp.blogspot.com/-Ho7vuFhRA6g/UVxQYXKCx8I/AAAAAAAABdo/wWbB5_E1z7o/s1600/36012.jpg", "Bus", "loremIpsum", random.nextInt(10000)).save(failOnError: true)

        new Cart("test", new Date()).save(failOnError: true)
    }

    void "Creation of cart"(){
        when:
            def res = controller.list()
        then:
            res.carts.size() == 1
    }

    void "Add deals to cart"(){
        given:
            params.dealId = "1"
        when:
            controller.addDealToCart()
            def res = session['currentCart'] as Cart
        then:
            res.getDeals().size() == 1
    }
}
