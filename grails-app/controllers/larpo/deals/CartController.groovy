package larpo.deals
import groovy.json.*

import org.grails.datastore.mapping.query.api.BuildableCriteria

class CartController {

    def list() {
        Cart[] carts = Cart.list()
        for (cart in carts){
            cart.deals.sort{it.id}
        }

        [carts: carts]
    }

    def addDealToCart() {
        if (session['currentCart'] == null){
            session['currentCart'] = new Cart("current cart", null)
        }

        if (!dealInCart(params.dealId as long)) {
            Cart currentCart = session['currentCart']
            currentCart.addToDeals(getDeal(params.dealId))
        }

        [currentCart: session['currentCart']]
        redirect action: 'list', controller: 'deal'
    }

    private Deal getDeal(String dealId){
        BuildableCriteria c = Deal.createCriteria()

        return c.list{
            eq("id", dealId as long)
        }[0]
    }

    private Boolean dealInCart(Long dealId){
        Cart currentCart = session['currentCart']

        for (deal in currentCart.getDeals()){
            if (deal.id == dealId){
                return true
            }
        }

        return false
    }
}
