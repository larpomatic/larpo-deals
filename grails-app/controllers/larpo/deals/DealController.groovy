package larpo.deals

import org.hibernate.Criteria

class DealController {

    def list() {
        List<Deal> deals = Deal.list()

        def c = Deal.createCriteria()
        if (params.search != null)
        {
            deals = c.list
                {
                    like('name', '%' + params.search + '%')
                }
        }

            [deals: deals]

    }
}
