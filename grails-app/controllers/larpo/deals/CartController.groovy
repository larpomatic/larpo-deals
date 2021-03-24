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
        Application.NewCurrentCart(session)
        List<Cart> carts = Cart.list()
        // List<Cart> carts = Cart.findAll{name != "Current Cart"}//.list()

        // def CurrentCart = Cart.findByName("Current Cart")

        [carts: carts, CurrentCart: session.CurrentCart]
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
