package larpo.deals

import grails.gorm.transactions.Transactional

@Transactional
class CartService {

    int cost(Set<Deal> deals) {
        int res = 0
        deals.each { Deal d ->
            res += d.price
        }
        return res
    }
}
