package larpo.deals

import larpo.cart.Cart

import java.text.SimpleDateFormat

class BootStrap {
    private static final String DESCRIPTION = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book";

    def init = { servletContext ->
        List<Deal> deals1 = new ArrayList<>()
        deals1.add(new Deal('Truck', DESCRIPTION, 'https://participons.bourg-la-reine.fr/media/cache/default_blockHeader/default/0001/01/ba9d7558b4598e6ef1e4af4ee9e8913b945dcc09.jpeg', new Random().nextInt(10000)).save(failOnError: true))
        deals1.add(new Deal('Bus', DESCRIPTION, "https://thumbs.dreamstime.com/b/le-petit-bus-s-arr%C3%AAte-long-de-la-route-qui-m%C3%A8ne-%C3%A0-mandalay-myanmar-express-blanc-pr%C3%AAt-partir-birmanie-166108432.jpg", new Random().nextInt(10000)).save(failOnError: true))

        List<Deal> deals2 = new ArrayList<>()
        deals2.add(new Deal('Bus', DESCRIPTION,'https://media.routard.com/image/86/5/flixbus.1572865.w740.jpg', new Random().nextInt(10000)).save(failOnError: true))

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH)
        Date date = simpleDateFormat.parse(new Date().toString())

        List<Cart> carts = new ArrayList<>()
        carts.add(new Cart(deals1, 'Lovely Cart', date, 3500, [(deals1[0].id.toString()): 1, (deals1[1].id.toString()): 1]).save(deepValidate: false))
        carts.add(new Cart(deals2, 'Amazing Cart', Date.parse("dd/MM/yyyy HH:mm", '28/02/2014 17:52'), 4534, [(deals2[0].id.toString()): 1]).save(deepValidate: false))
    }
    def destroy = {
    }
}
