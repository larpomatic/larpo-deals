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
        List<Cart> carts = Cart.list()
        [carts: carts]
    }

    def addDealToCart(Integer id)
    {
        if (session.isNew())
            session["currentCart"] = new Cart(new Date(), "Current Cart").save(failOnError: true, flush: true)
        Deal deal = Deal.get(id)

        Boolean b = Boolean.TRUE
        for (d in session.currentCart.deals)
            if (deal.id == d.id)
            {
                println("already in Current Cart")
                flash.message = "Deal Already in Current Cart"
                b = Boolean.FALSE
            }

        if (b)
        {
            session.currentCart.addToDeals(deal).save(failOnError: true, flush: true)
            flash.message = "Deal added to Current Cart"
        }

        redirect(url: "/larpo-deals/deal/list")

        [deal: deal]
    }
}
