package larpo.deals

class DealController
{
    // def index() { }

   def list(params)
    {
        Application.NewCurrentCart(session)
        def c = Deal.createCriteria()
        def deals = c.list()
        {
            if (params.search)
                ilike("name", "%" + params.search + "%")
        }

        Cart CurrentCart = session.CurrentCart
        [deals: deals, CurrentCart: CurrentCart, cost: CartService.cost(CurrentCart)]
    }
}