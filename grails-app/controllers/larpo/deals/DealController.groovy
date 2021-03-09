package larpo.deals

import org.grails.datastore.mapping.query.api.BuildableCriteria

class DealController {

    /**
     * @return The variable "deals" that contains either all the deals
     * or a part of them, if filtered by a userSearch
     */
    def list() {
        String userSearch = params.userSearch
        Object deals

        if (userSearch != null){
            BuildableCriteria c = Deal.createCriteria()

            deals = c.list{
                    like("name", userSearch + "%")
            }
        }
        else {
            deals = Deal.list()
        }

        [deals: deals]
    }
}
