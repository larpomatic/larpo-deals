package larpo.deals

class Cart {

    String name
    Date dateCreated

    static hasMany = [deals: Deal]
    static mapping = {
        deals cascade: 'all-delete-orphan'
    }

    Cart(String name, Date dateCreated) {
        this.name = name
        this.dateCreated = dateCreated
    }

    static constraints = {
    }
}
