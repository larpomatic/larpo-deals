package larpo.deals

import larpo.cart.Cart

class CartService {
    static transactional = false

    static Integer cost(Cart cart) {
        if (cart == null)
            return 0
        int price = 0
        for (Deal deal in cart.deals) {
            price += deal.getPrice() * cart.quantities.get(deal.id as String)
        }
        return price
    }
}
