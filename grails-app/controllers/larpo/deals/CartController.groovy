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

    // Add a deal in current cart
    def addDealToCart() {
        // If current cart is null, create a new one
        if (session['currentCart'] == null) {
            session['currentCart'] = new Cart("Current Cart", new Date())
        }

        // If deal to add isn't in current cart, add it, else don't do anything
        if (!isDealInCart(params.dealId as long)) {
            Cart currentCart = session['currentCart'] as Cart
            currentCart.addToDeals(getDeal(params.dealId as long))
        }

        redirect action: 'list', controller: 'deal'
    }

    // Save current cart
    def save() {
        Cart currentCart = session['currentCart'] as Cart

        // If given a name, rename current cart
        if (params.rename) {
            currentCart.name = params.rename
        }

        // Get total cost of the cart
        currentCart.cost = cartService.cost(currentCart.deals)

        // Save current cart and reset it to null for the next one
        currentCart.save(failOnError: true, flush: true)
        session['currentCart'] = null

        redirect action: 'list', controller: 'cart'
    }

    // Get a deal by id
    private Deal getDeal(long dealId) {
        def c = Deal.createCriteria()

        return c.list() {
            eq("id", dealId)
        }[0]
    }

    // Check if a deal is already in the current cart
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
