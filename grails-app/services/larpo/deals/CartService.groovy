package larpo.deals

import grails.gorm.transactions.Transactional

@Transactional
class CartService {

    /*def serviceMethod() {
    }*/

    static Integer cost(Cart cart)
    {
        Integer s = 0
        /*if (!cart.deals)
            return s*/
        // System.err.println(cart)
        for (deal in cart.deals)
            s += deal.price
        return s
    }
}