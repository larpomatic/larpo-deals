package larpo.deals

class Cart {
    String name
    Date dateCreated

    static hasMany = [deals: Deal]

    Cart(String name, Date dateCreated) {
        this.name = name
        this.dateCreated = dateCreated
    }

    static constraints = {}
}
