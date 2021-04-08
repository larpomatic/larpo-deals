package larpo.deals
//Cart Controller
class CartController {

    CartService cartService
    //show list of carts
    //if no actual cart, create a session cart
    def list()
    {
        if (session != null)
            Cart a = new Cart('session', new Date(1996,12,20))
        List<Cart> carts = Cart.list()

        Integer price = 0
        if (session != null && session.cart != null) {
            price = cartService.cost(session.cart)
        }
        else
        {price = 0}

        [carts: carts, price:price]
    }
    //add a deal to the actual session cart
    //check if the deal is already in the cart, if it is so hte deal is not added
    //send a message to the user to know if the add worked well
    def addDealToCart()
    {
        if (!session.cart)
            session.cart = new Cart("My cart", new Date())


        def c = Deal.createCriteria()
        Deal newDeal = c.list { eq('id', params.dealToAdd.toLong()) }[0]

        int hasFound = 0
        if (session.cart.deals) {
            for (deal in session.cart.deals)
            {
                if (deal.id == newDeal.id.toLong()) {
                    hasFound = 1
                }
            }
        }
        //toast pop up
        if (hasFound == 0) {
            session.cart.addToDeals(newDeal)
            session["DisplayToast"] = true
        }
        else {
            session["DisplayToasts"] = true
        }

        redirect(controller: "Deal", action: "list")
     }
    //add the current cart to the database
    def saveCurrentCart()
    {
        if (params.wish)
        {
            session.cart.name = params.wish
        }
        session.cart.save(failOnError: true, flush:true)
        session["DisplayCartToast"] = true
        session.cart = null
        redirect(controller: "Cart", action: "list")
    }

}
