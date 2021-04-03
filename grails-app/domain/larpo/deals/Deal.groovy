package larpo.deals

class Deal {
    String name
    String description
    String caption
    int price

    Deal(String name, String description, String caption, int price) {
        this.name = name
        this.description = description
        this.caption = caption
        this.price = price
    }

    static constraints = {
        name size: 2..100, blank: false
        description size: 2..255, blank: false
    }
}
