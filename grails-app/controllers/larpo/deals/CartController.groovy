package larpo.deals

import org.grails.datastore.mapping.query.api.BuildableCriteria

class CartController {

    def list() {
        Cart[] carts = Cart.list()

        //TODO sort the list

        [carts: carts]
    }

    def addDealToCart() {
        if (session['currentCart'] == null){
            session['currentCart'] = new Cart("current cart", null)
        }

        Long dealId = params.dealId as long
        Cart currentCart = session['currentCart']

        if (dealId <= 0 || dealId > Deal.list().size()){
            throw new ArrayIndexOutOfBoundsException("This dealId does not exist: " + dealId)
        }

        if (!dealInCart(dealId)) {
            currentCart.addToDeals(getDeal(dealId))
            //TODO message
            g.message(message: "The deal was added to your cart")
        } else {
            flash.message = "The deal was already into your cart"
        }

        [currentCart: currentCart]
        redirect action: 'list', controller: 'deal'
    }

    def save() {
        session["currentCart"].save(failOnError: true, flush: true)

        session["currentCart"] = null

        redirect action: 'list', controller: 'cart'
    }

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

    private Boolean dealInCart(Long dealId){
        Cart currentCart = session['currentCart']

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
