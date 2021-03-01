package larpo.deals

class Deal {
    static constraints = {}

    String name
    String description
    String caption
    Integer price

    Deal(String caption, String name, String description, Integer price) {
        this.name = name
        this.description = description
        this.caption = caption
        this.price = price
    }
}
