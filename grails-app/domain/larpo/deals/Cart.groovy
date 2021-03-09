package larpo.deals

class Cart {

    String name
    Date dateCreated

    static hasMany = [deals: Deal]

    static mapping = {
        deals cascade: 'all-delete-orphan'
    }

    static constraints = {
    }

    Cart(String name, Date dateCreated, List<Deal> AllDeal) {
        this.name = name
        this.dateCreated = dateCreated
        deals = []
        for (deal in AllDeal) {
            deals.add(deal)
        }
    }
}
