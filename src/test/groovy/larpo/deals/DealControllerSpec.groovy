package larpo.deals

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import org.hibernate.annotations.common.reflection.XPackage
import spock.lang.Specification

class DealControllerSpec extends Specification implements ControllerUnitTest<DealController>, DataTest {


    @Override
    Class[] getDomainClassesToMock() {
        // Liste des domains utiliser par le controller
        return [Deal]
    }

    def setup() {
        new Deal('https://cdn.shopify.com/s/files/1/2122/5885/products/GarbageTruckwithFaceOrnament-OR1346_582x582.jpg?v=1502727672', 'Truck', "azerty", 10).save(failOnError: true)
        new Deal('https://images-na.ssl-images-amazon.com/images/I/61kHFl7bYRL._AC_SX425_.jpg', 'Bus', "azerty", 100).save(failOnError: true)
        new Deal('https://m.media-amazon.com/images/I/519gkH3zvOL._ML160_.jpg', 'Bus', "azerty", 1).save(failOnError: true)

    }

    def cleanup() {
    }

    void "test null search"() {
        given:
        params.search = null
        when:
        def res = controller.list()
        then:
        res.deals.size() == 3
    }

    void "test Bus search"() {
        given:
        params.search = "Bus"
        when:
        def res = controller.list()
        then:
        res.deals.size() == 2
        boolean name = true
        for (elm in res.deals) {
            name = name && elm.name == "Bus"
            if (!name) {
                break
            }
        }
        name
    }

    void "test Truck search"() {
        given:
        params.search = "Truck"
        when:
        def res = controller.list()
        then:
        res.deals.size() == 1
        res.deals[0].name == "Truck"
        boolean name = true
        for (elm in res.deals) {
            name = name && elm.name == "Truck"
            if (!name) {
                break
            }
        }
        name
    }

    void "test Wrong search"() {
        given:
        params.search = "Wrong"
        when:
        def res = controller.list()
        then:
        res.deals.size() == 0
    }
}

