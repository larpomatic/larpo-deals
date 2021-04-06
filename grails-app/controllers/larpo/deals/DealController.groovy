package larpo.deals

import org.hibernate.Criteria

class DealController {

    //list all deal, with if not empty a name filter
    def list() {
        List<Deal> deals = Deal.list()

        def c = Deal.createCriteria()
        if (params.search != null) {
            deals = c.list
                    {
                        ilike('name', '%' + params.search + '%')
                    }
        }


        [deals: deals, cartPrice: CartService.cost(session.cart)]

    }

}
