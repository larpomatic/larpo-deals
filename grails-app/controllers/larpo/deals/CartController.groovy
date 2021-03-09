package larpo.deals

class CartController {

    def addDealToCart() {
        if (session.cart == null)
        {
            session.cart = new Cart("Session cart", new Date(),[])
        }


        def c = Deal.createCriteria()
        List<Deal> dealsList = c.list {
            eq('id', params.dealToAdd.toLong())
        }
        
        session.cart.addToDeals(dealsList[0])


        redirect(controller: "Deal", action: "list")
    }


    def list() {
        List<Cart> carts = Cart.list()

        [carts: carts]
    }

}
