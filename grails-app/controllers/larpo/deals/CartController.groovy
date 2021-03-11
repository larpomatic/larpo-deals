package larpo.deals

class CartController {
    def list() {
        def cart = session['currentCart']
        [carts: cart]
    }

    def addDealToCart() {
        if (session['currentCart'] == null) {
            session['currentCart'] = new Cart("Current Cart", new Date())
        }

        if (!isDealInCart(params.dealId.replaceAll("[^0-9]", ""))) {
            Cart currentCart = session['currentCart']
            currentCart.addToDeals(getDeal(params.dealId.replaceAll("[^0-9]", "")))
        }

        redirect action: 'list', controller: 'deal'
    }

    private Deal getDeal(String dealId) {
        def c = Deal.createCriteria()

        return c.list() {
            eq("id", dealId as long)
        }[0]
    }

    private Boolean isDealInCart(String dealId) {
        Cart currentCart = session['currentCart']

        for (deal in currentCart.deals) {
            if (deal.id == dealId as long) {
                return true
            }
        }
        return false
    }
}
