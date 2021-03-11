package larpo.deals

class Cart {
    static constraints = {}

    String name
    Date dateCreated

    static hasMany = [deals: Deal]

    Cart(String name, Date dateCreated) {
        this.name = name
        this.dateCreated = dateCreated
    }
}
