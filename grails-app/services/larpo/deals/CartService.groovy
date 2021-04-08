package larpo.deals

import grails.gorm.transactions.Transactional
//cart service to calculate price of a cart
@Transactional
class CartService {

    static Integer cost(Cart myCart) {

        Integer totalPrice = 0
        if (myCart != null) {
            for (deal in myCart.deals) {
                totalPrice += deal.price
            }
        }
        return totalPrice
    }
}
