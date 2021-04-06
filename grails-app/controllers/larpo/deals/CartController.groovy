package larpo.deals

class CartController {
    CartService cartService

    def list() {
        Cart currentCart = session['currentCart'] as Cart
        int totalPrice = 0
        if (currentCart) {
            totalPrice = cartService.cost(currentCart.deals)
        }
        [currentCart: currentCart, carts: Cart.list(), totalPrice: totalPrice]
    }

    def addDealToCart() {
        if (session['currentCart'] == null) {
            session['currentCart'] = new Cart("Current Cart", new Date())
        }

        if (!isDealInCart(params.dealId as long)) {
            Cart currentCart = session['currentCart'] as Cart
            currentCart.addToDeals(getDeal(params.dealId as long))
        }

        redirect action: 'list', controller: 'deal'
    }

    def save() {
        Cart currentCart = session['currentCart'] as Cart
        if (params.rename) {
            currentCart.name = params.rename
        }
        currentCart.cost = cartService.cost(currentCart.deals)
        currentCart.save(failOnError: true, flush: true)
        session['currentCart'] = null

        redirect action: 'list', controller: 'cart'
    }

    private Deal getDeal(long dealId) {
        def c = Deal.createCriteria()

        return c.list() {
            eq("id", dealId)
        }[0]
    }

    private Boolean isDealInCart(long dealId) {
        Cart currentCart = session['currentCart'] as Cart

        for (deal in currentCart.deals) {
            if (deal.id == dealId) {
                return true
            }
        }
        return false
    }
}
