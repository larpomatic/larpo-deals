package larpo.deals

class CartController {

    // def index() { }

    /*def list()
    {
        List<Deal> deals
        for (deal in Cart.get(1).deals)
            deals.add(deal)
        [deals: deals]
    }*/

    def list()
    {
        // def cartservice = new CartService()
        Application.NewCurrentCart(session)
        List<Cart> carts = Cart.list()
        //Integer price = CartService.cost(new Cart())
        Cart CurrentCart = session.CurrentCart
        [carts: carts, CurrentCart: CurrentCart, cost: CartService.cost(CurrentCart)]
    }

    def addDealToCart(Integer id)
    {
        /*if (session.isNew())
            session["currentCart"] = new Cart(new Date(), "Current Cart").save(failOnError: true, flush: true)*/
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
            session.CurrentCart.addToDeals(deal)//.save(failOnError: true, flush: true)
            flash.message = "Deal added to Current Cart"
        }

        redirect(url: "/larpo-deals/deal/list")


        [deal: deal]
    }

    def save(params)
    {
        Cart NewCart = new Cart(new Date(), params.SaveCart)
        NewCart.deals = session.CurrentCart.deals
        NewCart.save(failOnError: true, flush: true)
        flash.message = "Cart saved"
        redirect(url: "/larpo-deals/cart/list")
        session["CurrentCart"] = new Cart(new Date(), "Current Cart")//.save(failOnError: true, flush: true)
    }
}
