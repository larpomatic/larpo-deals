package larpo.deals

class Deal {

    String caption
    String name
    String description
    Integer price

    Deal(String caption, String name, String description, Integer price) {
        this.caption = caption
        this.name = name
        this.description = description
        this.price = price
    }

    static constraints = {
        caption size: 0..255
        name size: 0..255
        description size: 0..255
        price min: 0, max: 10000
    }
}
