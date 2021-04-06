package larpo.deals

class Cart {
    String name
    Date dateCreated
    Integer cost

    static hasMany = [deals: Deal]

    Cart(String name, Date dateCreated) {
        this.name = name
        this.dateCreated = dateCreated
        cost = 0
    }

    static constraints = {}
}
