package larpo.deals

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CartSpec extends Specification implements DomainUnitTest<Cart>
{
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
}