package larpo.deals.deal

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import larpo.deals.Deal
import larpo.deals.DealController
import spock.lang.Specification

class DealControllerSpec extends Specification implements ControllerUnitTest<DealController>, DataTest {
    List<Deal> deals = new ArrayList<>()
    private static final String DESCRIPTION = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book";

    @Override
    Class[] getDomainClassesToMock() {
        // Liste des domains utilisés par le contrôleur
        return [Deal]
    }

    def setup() {
        deals.add(new Deal('Truck', DESCRIPTION, 'http://2.bp.blogspot.com/-O8H8VwjsgHQ/UTSApHY3M_I/AAAAAAAAAhU/AlSeJgJ3ijE/s400/monster-motorbike-1-big.jpg', new Random().nextInt(10000)).save(failOnError: true))
        deals.add(new Deal('Bus', DESCRIPTION, 'http://4.bp.blogspot.com/-Van_nK7u00s/UVxQXKZvJJI/AAAAAAAABdg/NzAitf6enl4/s1600/21e004.jpg', new Random().nextInt(10000)).save(failOnError: true))
        deals.add(new Deal('Bus', DESCRIPTION,'http://4.bp.blogspot.com/-Ho7vuFhRA6g/UVxQYXKCx8I/AAAAAAAABdo/wWbB5_E1z7o/s1600/36012.jpg', new Random().nextInt(10000)).save(failOnError: true))

    }

    def cleanup() {
        deals.clear()
    }

    void "should find empty Deal with Criteria"() {
        given: 'A list of deal in memory'
            params.search = ""
        when:
            def res = controller.list()
        then:
            assert res.deals.size() == 3
        cleanup:
            cleanup()
    }

    void "should find incorrect Deal with Criteria"() {
        given: 'A list of deal in memory'
            params.search = "hello"
        when:
            def res = controller.list()
        then:
            assert res.deals.size() == 0
        cleanup:
            cleanup()
    }

    void "should find correct Deal with Criteria 1"() {
        given: 'A list of deal in memory'
            params.search = "bus"
        when:
            def res = controller.list()
        then:
            assert res.deals.size() == 2
            assert res.deals.get(0).name == "Bus"
            assert res.deals.get(1).name == "Bus"
        cleanup:
            cleanup()
    }

    void "should find correct Deal with Criteria 2"() {
        given: 'A list of deal in memory'
            params.search = "uck"
        when:
            def res = controller.list()
        then:
            assert res.deals.size() == 1
            assert res.deals.get(0).name == "Truck"
        cleanup:
            cleanup()
    }
}
