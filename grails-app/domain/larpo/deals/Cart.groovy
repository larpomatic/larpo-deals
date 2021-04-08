package larpo.deals

//Cart model, with a name list of deals, creation date
class Cart {

    String name
    static hasMany = [deals: Deal]
    Date dateCreated

    Cart(String name, Date dateCreated)
    {
        this.name = name
        this.dateCreated = dateCreated
    }

    static mapping = {
        deals cascade: 'all-delete-orphan'
    }

    static constraints = {
    }
}
