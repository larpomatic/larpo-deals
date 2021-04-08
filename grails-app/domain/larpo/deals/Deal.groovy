package larpo.deals

//Deal model with a name, a description, caption and a price
class Deal {

    String name
    String description
    String caption
    Integer price

    Deal(String caption, String name, String description, Integer price)
    {
        this.caption = caption
        this.name = name
        this.description = description
        this.price = price
    }

    static constraints = {
    }
}
