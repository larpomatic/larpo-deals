package larpo.cart


import larpo.deals.CartService
import larpo.deals.Deal
import org.grails.datastore.mapping.query.api.BuildableCriteria


class CartController {
    CartService cartService

    def index() {
        Cart cartSavedInSession = session.getAttribute("CurrentCart") as Cart
        def carts = Cart.list(order: 'asc')
        [carts: carts, cost: cartService.cost(cartSavedInSession)]
    }

    def addDealToCart() {
        Deal dealFound = getDealById()

        if (!session.getAttribute("CurrentCart")) {
            setCurrentCartInSession(dealFound)
        }
        else {
            setNewCurrentCartInSession(dealFound)
        }

        redirect(controller: "deal", action: "list")
    }

    private void setNewCurrentCartInSession(Deal dealFound) {
        Cart cartSavedInSession = session.getAttribute("CurrentCart") as Cart
        if (isTheSameDeal(cartSavedInSession, dealFound))
            cartSavedInSession.quantities[dealFound.id.toString()] += 1
        else {
            cartSavedInSession.addToDeals(dealFound)
            cartSavedInSession.quantities[dealFound.id.toString()] = 1
        }
        session.setAttribute("CurrentCart", cartSavedInSession)
    }

    private void setCurrentCartInSession(Deal dealFound) {
        Cart currentCart = Cart.create()
        initCart(currentCart, dealFound)
        session.setAttribute("CurrentCart", currentCart)
    }

    private void initCart(Cart currentCart, Deal dealFound) {
        String buf = message(code: "current.cart")
        currentCart.setName(buf)
        currentCart.addToDeals(dealFound)
        currentCart.setDateCreated(new Date())
        currentCart.setQuantities([(dealFound.id as String): 1] as Map<Long, Integer>)
    }

    private Deal getDealById() {
        BuildableCriteria crit = Deal.createCriteria()
        Deal dealFound = crit.get { eq('id', params.id.toLong()) } as Deal
        dealFound
    }

    private static boolean isTheSameDeal(Cart cartSavedInSession, Deal dealFound) {
        for (Deal deal in cartSavedInSession.getDeals())
        {
            if (deal.id == dealFound.id)
                return true
        }
        return false
    }


    def save() {
        Cart cartSavedInSession = session["CurrentCart"] as Cart

        //If we rename the current cart
        if (params.rename)
            cartSavedInSession.setName(params.rename)

        cartSavedInSession.setPrice(CartService.cost(cartSavedInSession))
        cartSavedInSession.save(flush: true)

        session.removeAttribute("CurrentCart")
        redirect(controller: "cart", action: "index")
    }
}