package larpo.deals

class CartController {

    // def index() { }

    def list()
    {
        Application.NewCurrentCart(session)
        List<Cart> carts = Cart.list()
        Cart CurrentCart = session.CurrentCart
        [carts: carts, CurrentCart: CurrentCart, cost: CartService.cost(CurrentCart)]
    }

    def addDealToCart(Integer id)
    {
        Application.NewCurrentCart(session)
        Deal deal = Deal.get(id)

        Boolean b = Boolean.TRUE
        for (d in session.CurrentCart.deals)
            if (deal.id == d.id)
            {
                println("already in Current Cart")
                flash.message = "Deal Already in Current Cart"
                b = Boolean.FALSE
            }

        if (b)
        {
            session.CurrentCart.addToDeals(deal)
            flash.message = "Deal added to Current Cart"
            flash.b = "1"
        }

        redirect(url: "/larpo-deals/deal/list")

        [deal: deal]
    }

    def save(params)
    {
        Cart NewCart = new Cart(new Date(), params.SaveCart)
        NewCart.deals = session.CurrentCart.deals
        NewCart.cost = CartService.cost(NewCart)
        NewCart.save(failOnError: true, flush: true)
        flash.message = "Cart saved"
        redirect(url: "/larpo-deals/cart/list")
        session["CurrentCart"] = new Cart(new Date(), "Current Cart")
    }
}