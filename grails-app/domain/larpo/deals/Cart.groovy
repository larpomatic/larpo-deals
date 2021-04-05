package larpo.deals

class Cart {

    String name
    Date dateCreated
    Integer[] lutNbDeals

    static hasMany = [deals: Deal]
    static mapping = {
        deals cascade: 'none'
    }

    Cart(String name, Date dateCreated) {
        this.name = name
        this.dateCreated = dateCreated
        lutNbDeals = [null]
        lutNbDeals += [0] * (Deal.list().size())
    }

    static constraints = {
        name size: 0..255
    }
}
