package larpo.cart

import larpo.deals.Deal

class Cart {
    String name
    Date dateCreated
    int price
    Map<Long, Integer> quantities

    List<Deal> deals = new ArrayList()
    static hasMany = [deals: Deal]

    Cart(deals, String name, Date dateCreated, int price, Map<Long, Integer> quantities) {
        this.deals = deals
        this.name = name
        this.dateCreated = dateCreated
        this.price = price
        this.quantities = quantities
    }

    static mapping = {
        deals cascade: 'all-delete-orphan'
    }

    static constraints = {
        name size: 2..100, blank: false
    }
}
