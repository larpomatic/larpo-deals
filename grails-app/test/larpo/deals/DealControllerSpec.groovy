package larpo.deals

import spock.lang.Specification

class DealControllerSpec extends Specification
        implements ControllerUnitTest<DealController>, DataTest  {

    @Override
    Class[] getDomainClassesToMock() {
        // Liste des domains utilisés par le contrôleur
        return [Deal]
    }
    // Methode pour initialiser la BDD
    def setupData() {}

    void "Empty search"(){
        given: setupData()
        when:
        def res = DealController.list()
        then:
        res.SelectIntrigueError == "plot.DealError"
    }
}