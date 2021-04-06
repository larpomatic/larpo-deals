package larpo.deals

import grails.gorm.transactions.Transactional

@Transactional
class CartService {

    /**
     * @param cart
     * @return the total cost of a cart, adding all the prices of the Deals inside of it
     */
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

    /**
     *
     * @param cart
     * @return the number of deals inside of a cart
     */
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
