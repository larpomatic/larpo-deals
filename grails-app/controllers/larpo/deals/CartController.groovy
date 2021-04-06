package larpo.deals

import org.grails.datastore.mapping.query.api.BuildableCriteria

class CartController {

    /**
     * @return the list of carts that have been saved + the number of deals of the current cart
     */
    def list() {
        Cart[] carts = Cart.list()

        Integer cost = CartService.cost(session['currentCart'] as Cart)

        [carts: carts, cost: cost, nbDeals: CartService.getNbDeals(session["currentCart"] as Cart)]
    }

    /**
     * Adds a deal to the current cart. Throws exception if not possible
     */
    def addDealToCart() {
        if (session['currentCart'] == null){
            session['currentCart'] = new Cart("current cart", null)
        }

        Long dealId = params.dealId as long
        Cart currentCart = session['currentCart'] as Cart

        if (dealId <= 0 || dealId > Deal.list().size()){
            throw new ArrayIndexOutOfBoundsException("This dealId does not exist: " + dealId)
        }

        if (!dealInCart(dealId)) {
            currentCart.addToDeals(getDeal(dealId))
        }

        currentCart.lutNbDeals[dealId.toInteger()] += 1
        session["DisplayToast"] = true

        [currentCart: currentCart]
        redirect action: 'list', controller: 'deal'
    }

    /**
     * Saves the current cart
     */
    def save() {
        session["currentCart"].save(failOnError: true, flush: true)

        session["currentCart"] = null

        redirect action: 'list', controller: 'cart'
    }

    /**
     * changes the name of the current cart
     */
    def changeName() {
        session["currentCart"].name = params.cartName

        redirect action: 'list', controller: 'cart'
    }

    /**
     * @param dealId
     * @return the deal that has corresponding id. Throws exception if there is no such existing deal
     */
    private Deal getDeal(Long dealId){
        BuildableCriteria c = Deal.createCriteria()

        Deal[] deals = c.list {
            eq("id", dealId)
        }

        if (deals.size() <= 0){
            throw new ArrayIndexOutOfBoundsException("This dealId does not exist: " + dealId)
        }

        return deals[0]
    }

    /**
     * @param dealId
     * @return true if a deal is inside of the current cart, false otherwise
     */
    private Boolean dealInCart(Long dealId){
        Cart currentCart = session['currentCart'] as Cart

        if (currentCart == null){
            return false
        }

        for (deal in currentCart.getDeals()){
            if (deal.id == dealId){
                return true
            }
        }

        return false
    }
}
