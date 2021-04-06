package larpo.deals

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class DealControllerSpec extends Specification implements ControllerUnitTest<DealController>, DataTest {

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

    void "test no search"() {
        given: params.userSearch = null
        when: Object list = controller.list()
        then: list.deals.size() == 6
    }

    void "test search Bus"() {
        given: params.userSearch = "Bus"
        when: Object list = controller.list()
        then: list.deals.size() == 2
    }

    void "test incorrect search"() {
        given: params.userSearch = "bfhekbfcihjz<sbdc"
        when: Object list = controller.list()
        then: list.deals.size() == 0
    }

    void "test search Completion forward"() {
        given: params.userSearch = "B"
        when: Object list = controller.list()
        then: list.deals.size() == 3
    }

    void "test search Completion backward"() {
        given: params.userSearch = "us"
        when: Object list = controller.list()
        then: list.deals.size() == 2
    }

    void "test search case-insensitive"() {
        given: params.userSearch = "bus"
        when: Object list = controller.list()
        then: list.deals.size() == 2
    }
}
