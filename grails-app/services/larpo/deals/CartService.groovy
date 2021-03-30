package larpo.deals

import grails.gorm.transactions.Transactional

@Transactional
class CartService {

    static Integer cost(Cart cart) {
        if (cart == null){
            return 0
        }

        Integer cost = 0

        for (deal in cart.deals){
            cost += deal.price * cart.getLutNbDeals()[deal.id as Integer]
        }

        return cost
    }

    static Integer getNbDeals(Cart cart){
        if (cart == null){
            return 0
        }

        Integer nbDeals = 0

        for (deal in cart.getDeals()){
            nbDeals += cart.getLutNbDeals()[deal.id as Integer]
        }

        return nbDeals
    }
}
