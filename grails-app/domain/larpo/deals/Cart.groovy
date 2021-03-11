package larpo.deals

class Cart
{
    String name
    static hasMany = [deals: Deal]
    Date dateCreated

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
    }
}
