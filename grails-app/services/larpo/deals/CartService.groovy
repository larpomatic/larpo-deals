package larpo.deals

import grails.gorm.transactions.Transactional

@Transactional
class CartService {

    static Integer cost(Cart cart) {
        if (cart == null) {
            return 0
        }
        Integer price = 0;
        for (Deal deal in cart.deals) {
            price = price + deal.price
        }

        return price
    }
}
