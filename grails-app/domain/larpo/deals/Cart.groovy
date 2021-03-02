package larpo.deals

class Cart {

    String name
    List<Deal> deals
    Date dateCreated

    static constraints = {
    }

    Cart(String name, Deal deal, Date dateCreated) {
        this.name = name
        this.deals = [deal]
        this.dateCreated = dateCreated
    }
}
