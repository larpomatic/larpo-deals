package larpo.deals
import org.hibernate.Criteria

class DealController {

    CartService cartService
    //show list of deal
    //calculate price of current cart
    def list()
    {
        List<Deal> deals = Deal.list()

        if (params.wish) {
            def c = Deal.createCriteria()
            deals = c.list () {
                ilike("name", '%' + params.wish + '%')
            }
        }
        Integer price = 0

        if (session != null && session.cart != null) {
            price = cartService.cost(session.cart)
        }
        else
            {price = 0}

        [deals: deals, price:price]
    }

}
