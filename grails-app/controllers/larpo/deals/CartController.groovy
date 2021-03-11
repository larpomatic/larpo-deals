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
}
