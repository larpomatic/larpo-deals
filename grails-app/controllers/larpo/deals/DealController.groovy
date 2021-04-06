package larpo.deals

class DealController {
    CartService cartService

    def list() {
        Cart currentCart = session['currentCart'] as Cart
        int totalPrice = 0
        if (currentCart) {
            totalPrice = cartService.cost(currentCart.deals)
        }

        if (params.search) {
            def c = Deal.createCriteria()
            def deals = c.list
                    {
                        ilike('name', '%' + params.search + '%')
                    }
            [deals: deals, totalPrice: totalPrice]
        }
        else {
            [deals: Deal.list(), totalPrice: totalPrice]
        }
    }
}
