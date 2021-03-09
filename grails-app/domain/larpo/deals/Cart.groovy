package larpo.deals

class Cart {

    String name
    Date dateCreated

    static hasMany = [deals: Deal]
    static mapping = {
        deals cascade: 'none'
    }

    Cart(String name, Date dateCreated) {
        this.name = name
        this.dateCreated = dateCreated
    }

    static constraints = {
        name size: 0..255
    }
}
