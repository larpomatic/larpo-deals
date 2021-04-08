package larpo.deals
import org.hibernate.Criteria

class DealController {

    CartService cartService
    //show list of deal
    //calculate price of current cart
    def list()
    {
        List<Deal> deals = Deal.list()

        if (params.wish) {
            def c = Deal.createCriteria()
            deals = c.list () {
                ilike("name", '%' + params.wish + '%')
            }
        }
        Integer price = 0

        if (session != null && session.cart != null) {
            price = cartService.cost(session.cart)
        }
        else
            {price = 0}

        [deals: deals, price:price]
    }

    def saveCurrentDeal()
    {
        Integer price = 0
        String name = "unnamed"
        String description = "loremIpsum"
        String caption = "https://img.icons8.com/plasticine/2x/truck.png"
        if (params.price != null)
        {price = params.price.toInteger()}
        if (params.name.size() != 0)
        {name = params.name}
        if (params.description.size() != 0)
        {description = params.description}
        if (params.caption.size() != 0)
        {caption = params.caption}

        if (params.price.toInteger() < 0)
        {
            session["DisplayWrongDealToast"] = true
        }
        else {
            Deal newDeal = new Deal(caption, name, description, price).save(failOnError: true)
            session["DisplayDealToast"] = true
        }


        redirect(controller: "Deal", action: "list")
    }

}
