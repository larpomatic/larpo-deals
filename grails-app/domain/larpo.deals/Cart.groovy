package larpo.deals

class Cart {
    static constraints = {}

    String name
    List<Deal> deals
    Date dateCreated

    Cart(String name, List<Deal> deals, Date dateCreated) {
        this.name = name
        this.deals = deals
        this.dateCreated = dateCreated
    }
}
