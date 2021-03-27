package larpo.deals

class CartController {
    def list() {
        [currentCart: session['currentCart']]
        [carts: Cart.list()]
    }

    def addDealToCart() {
        if (session['currentCart'] == null) {
            session['currentCart'] = new Cart("Current Cart", new Date())
        }

        if (!isDealInCart(params.dealId as long)) {
            Cart currentCart = session['currentCart']
            currentCart.addToDeals(getDeal(params.dealId as long))
        }

        redirect action: 'list', controller: 'deal'
    }

    def save() {
        Cart current = session['currentCart']
        current.save(failOnError: true)
        session['currentCart'] = null
    }

    private Deal getDeal(long dealId) {
        def c = Deal.createCriteria()

        return c.list() {
            eq("id", dealId)
        }[0]
    }

    private Boolean isDealInCart(long dealId) {
        Cart currentCart = session['currentCart']

        for (deal in currentCart.deals) {
            if (deal.id == dealId) {
                return true
            }
        }
        return false
    }
}
