package larpo.deals

class CartController {
    def list() {
        [cart: Cart.list()]
    }

    def addDealToCart(Integer ID) {
        def c = Deal.createCriteria()
        List<Deal> deal = c.list {
            eq('id', ID)
        }



        new Cart("Test", deal, new Date()).save(failOnError: true)
    }
}
