package larpo.deals

import larpo.cart.Cart

class DealController {

    def list() {
        Cart cartSavedInSession = session.getAttribute("CurrentCart") as Cart
        if (params.search) {
            [deals: findByName("%" + params.search + "%"), cost: CartService.cost(cartSavedInSession)]
        } else {
            [deals: Deal.list(order: 'asc'), cost: CartService.cost(cartSavedInSession)]
        }
    }

    private static Object findByName(String name) {
        def crit = Deal.createCriteria()
        def res = crit.list {
            ilike("name", name)
        }
        return res
    }

}
