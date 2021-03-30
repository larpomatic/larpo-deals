package larpo.deals

class CartController {


    def addDealToCart() {
        if (session.cart == null)
        {
            session.cart = new Cart("Session cart", new Date(),[])
        }


        def c = Deal.createCriteria()
        List<Deal> dealsList = c.list {
            eq('id', params.dealToAdd.toLong())
        }

        boolean isAlreadyInDealsList = false

        for (Deal deal in session.cart.deals)
        {
            if (deal.id == params.dealToAdd.toLong())
            {
                isAlreadyInDealsList = true
                break
            }
        }

        if (!isAlreadyInDealsList) {
            session.cart.addToDeals(dealsList[0])
            session.cart.price = CartService.cost(session.cart)
            session.message = "Deal add in cart"
        }
        else
        {
            session.message = "Deal already in cart"
        }

        redirect(controller: "Deal", action: "list")
    }


    def list() {
        List<Cart> carts = Cart.list()



        [carts: carts, cartPrice: CartService.cost(session.cart)]
    }

    def SaveCart() {
        session.cart.save(failOnError: true, flush: true)
        session.cart = null

        redirect(controller: "Cart", action: "list")
    }


}
