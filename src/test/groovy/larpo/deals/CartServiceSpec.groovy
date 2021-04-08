package larpo.deals

import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class CartServiceSpec extends Specification
        implements ServiceUnitTest<CartService>, DataTest {

    @Override
    Class[] getDomainClassesToMock() {
        // Liste des domains utilisés par le contrôleur
        return [Deal, Cart]
    }

    def setup() {
        def deal1 = new Deal("http://2.bp.blogspot.com/-O8H8VwjsgHQ/UTSApHY3M_I/AAAAAAAAAhU/AlSeJgJ3ijE/s400/monster-motorbike-1-big.jpg", "Truck", "loremIpsum", 1000)
        def deal2 = new Deal("http://4.bp.blogspot.com/-Van_nK7u00s/UVxQXKZvJJI/AAAAAAAABdg/NzAitf6enl4/s1600/21e004.jpg", "Bus", "loremIpsum", 3784)
        def deal3 = new Deal("http://4.bp.blogspot.com/-Ho7vuFhRA6g/UVxQYXKCx8I/AAAAAAAABdo/wWbB5_E1z7o/s1600/36012.jpg", "Bus", "loremIpsum", 9084)

        deal1.save(failOnError: true)
        deal2.save(failOnError: true)
        deal3.save(failOnError: true)

        def deals = new HashSet<Deal>()
        deals.add(deal1)
        deals.add(deal2)
        deals.add(deal3)
        return deals
    }

    void "Null Set"() {
        given:
            def deals = null
        when:
            def res = service.cost(deals)
        then:
            res == 0
    }

    void "Set of every deal"() {
        given:
            def deals = setup()
        when:
            def res = service.cost(deals)
        then:
            res == 13868
    }
}
