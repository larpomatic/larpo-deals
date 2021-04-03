package larpo.deals

import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import larpo.cart.Cart
import spock.lang.Specification

import java.text.SimpleDateFormat

class CartServiceSpec extends Specification implements ServiceUnitTest<CartService>, DataTest {
    List<Deal> deals1 = new ArrayList<>()
    List<Deal> deals2 = new ArrayList<>()
    private static final String DESCRIPTION = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book";
    List<Cart> carts = new ArrayList<>()


    @Override
    Class[] getDomainClassesToMock() {
        // Liste des domains utilisés par le contrôleur
        return [Deal, Cart]
    }

    def setup() {
        deals1.add(new Deal('Truck', DESCRIPTION, 'https://participons.bourg-la-reine.fr/media/cache/default_blockHeader/default/0001/01/ba9d7558b4598e6ef1e4af4ee9e8913b945dcc09.jpeg', new Random().nextInt(10000)).save(failOnError: true))
        deals1.add(new Deal('Bus', DESCRIPTION, "https://thumbs.dreamstime.com/b/le-petit-bus-s-arr%C3%AAte-long-de-la-route-qui-m%C3%A8ne-%C3%A0-mandalay-myanmar-express-blanc-pr%C3%AAt-partir-birmanie-166108432.jpg", new Random().nextInt(10000)).save(failOnError: true))

        deals2.add(new Deal('Bus', DESCRIPTION,'https://media.routard.com/image/86/5/flixbus.1572865.w740.jpg', new Random().nextInt(10000)).save(failOnError: true))

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH)
        Date date = simpleDateFormat.parse(new Date().toString())

        carts.add(new Cart(deals1, 'Lovely Cart', date, deals1[0].price + deals1[1].price, [(deals1[0].id.toString()): 1, (deals1[1].id.toString()): 1]).save(deepValidate: false))
        carts.add(new Cart(deals2, 'Amazing Cart', Date.parse("dd/MM/yyyy HH:mm", '28/02/2014 17:52'), deals2[0].price, [(deals2[0].id.toString()): 1]).save(deepValidate: false))
    }

    def cleanup() {
        deals1.clear()
        deals2.clear()
        carts.clear()
    }

    void "should have a cost when a deal is added into a cart 1"() {
        given:
            Cart cart1 = carts.get(0)
        when:
            Integer cost = CartService.cost(cart1)
        then:
            assert cost == deals1[0].price + deals1[1].price
    }

    void "should have a cost when a deal is added into a cart 2"() {
        given:
            Cart cart2 = carts.get(1)
        when:
            Integer cost = CartService.cost(cart2)
        then:
            assert cost == deals2[0].price
    }

    void "should have no cost when a cart is null"() {
        given:
            Cart cart2 = null
        when:
            Integer cost = CartService.cost(cart2)
        then:
            assert cost == 0
    }
}
