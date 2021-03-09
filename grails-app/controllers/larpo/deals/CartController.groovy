package larpo.deals

class CartController {

    def addDealToCart() {


    }


    def list() {
        List<Cart> carts = Cart.list()

        [carts: carts]
    }

}
