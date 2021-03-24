package larpo.deals

class Cart
{
    String name
    static hasMany = [deals: Deal]
    Date dateCreated
    Integer cost

    static mapping =
    {
        // deals cascade: "none"
        deals cascade: "all-delete-orphan"
    }

    /*static constraints = {
    }*/

    Cart(Date dateCreated, String name)
    {
        this.name = name
        this.dateCreated = dateCreated
        this.cost = 0
    }
}
