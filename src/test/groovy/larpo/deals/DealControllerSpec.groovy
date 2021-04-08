package larpo.deals

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class DealControllerSpec extends Specification implements ControllerUnitTest<DealController>, DataTest
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
        setupData();
    }

    def cleanup()
    {
    }

    /*void "test something"() {
        expect:"fix me"
            true == false
    }*/

    void "empty search" ()
    {
        given: params.search = null
        when: def res = controller.list(params)
        then: res.deals.size() == 3
    }

    void "good Bus search" ()
    {
        given: params.search = "Bus"
        when: def res = controller.list(params)
        then:
            res.deals.size() == 2
            for (e in res.deals)
            {
                assert e.name == "Bus"
            }
    }
    void "bad Bike search" ()
    {
        given: params.search = "Bike"
        when: def res = controller.list(params)
        then: res.deals.size() == 0
    }

    void "good autocompletion T-ruck search" ()
    {
        given: params.search = "T"
        when: def res = controller.list(params)
        then: res.deals.size() == 1 && res.deals[0].name == "Truck"
    }
}