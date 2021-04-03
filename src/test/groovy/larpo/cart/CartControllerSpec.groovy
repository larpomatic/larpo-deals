package larpo.cart

import grails.testing.gorm.DataTest
import grails.testing.spring.AutowiredTest
import grails.testing.web.controllers.ControllerUnitTest
import groovy.json.JsonSlurper
import larpo.deals.CartService
import larpo.deals.Deal
import org.grails.datastore.mapping.query.api.BuildableCriteria
import spock.lang.Specification

import java.text.SimpleDateFormat
import java.util.stream.Collectors

class CartControllerSpec extends Specification implements ControllerUnitTest<CartController>, DataTest, AutowiredTest {
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

        carts.add(new Cart(deals1, 'Lovely Cart', date, 3500, [(deals1[0].id.toString()): 1, (deals1[1].id.toString()): 1]).save(deepValidate: false))
        carts.add(new Cart(deals2, 'Amazing Cart', Date.parse("dd/MM/yyyy HH:mm", '28/02/2014 17:52'), 4534, [(deals2[0].id.toString()): 1]).save(deepValidate: false))
    }

    def cleanup() {
        deals1.clear()
        deals2.clear()
        carts.clear()
    }

    void "should add a Deal to a new cart session"() {
        given: 'a deal'
            params.id = deals1[0].id.toString()
        when:
            controller.addDealToCart()
        then:
            assert session["CurrentCart"] != null

            Cart cartSavedInSession = session["CurrentCart"] as Cart
            Set<Deal> dealsSavedInSession = cartSavedInSession.deals

            assert dealsSavedInSession.size() == 1
            assert dealsSavedInSession[0].getName() == "Truck"
            assert dealsSavedInSession[0].getDescription() == DESCRIPTION
        cleanup:
            cleanup()

    }

    void "should add a Deal to an existing cart session 1"() {
        given: 'two deals and an existing session'
            params.id = deals1[0].id.toString()
            addDealToCart()
            params.id = deals2[0].id.toString()
        when:
            controller.addDealToCart()
        then:
            assert session["CurrentCart"] != null

            Cart cartSavedInSession = session["CurrentCart"] as Cart
            assert cartSavedInSession.getQuantities().get(deals1[0].id.toString()) == 1
            assert cartSavedInSession.getQuantities().get(deals2[0].id.toString()) == 1

            List<Deal> dealsSavedInSession = cartSavedInSession.deals
            assert dealsSavedInSession.size() == 2
            assert dealsSavedInSession[0].getName() == "Truck"
            assert dealsSavedInSession[0].getDescription() == DESCRIPTION
            assert dealsSavedInSession[1].getName() == "Bus"
            assert dealsSavedInSession[1].getDescription() == DESCRIPTION
        cleanup:
            cleanup()
    }

    void "should add another Deal to an existing cart session"() {
        given: 'two deals and an existing session'
            params.id = deals1[0].id.toString()
            addDealToCart()
            params.id = deals2[0].id.toString()
            addDealToAnExistingCartSession()
            params.id = deals2[0].id.toString()
        when:
            controller.addDealToCart()
        then:
            assert session["CurrentCart"] != null

            Cart cartSavedInSession = session["CurrentCart"] as Cart
            assert cartSavedInSession.getQuantities().get(deals1[0].id.toString()) == 1
            assert cartSavedInSession.getQuantities().get(deals2[0].id.toString()) == 2
        cleanup:
            cleanup()
    }

    void "should save the current cart session in memory"() {
        given:
            params.id = deals1[0].id.toString()
            addDealToCart()
            params.id = deals2[0].id.toString()
            addDealToAnExistingCartSession()
        when:
            controller.save()
        then:
            assert session["CurrentCart"] == null
            LinkedHashMap<Integer, Cart> maps = currentSession.datastore.getProperties()
                    .get("backingMap").getAt("larpo.cart.Cart") as LinkedHashMap<Integer, Cart>
            List<Cart> cartsSaved = maps.values().stream().collect(Collectors.toList())

            assert cartsSaved.size() == 3
            assert cartsSaved.get(2).name == "Current Cart"
            assert cartsSaved.get(2).price == deals1[0].getPrice() + deals2[0].getPrice()
            assert cartsSaved.get(2).quantities.get(deals1[0].id.toString()) == 1
            assert cartsSaved.get(2).quantities.get(deals2[0].id.toString()) == 1
    }



    private void addDealToCart() {
        BuildableCriteria crit = Deal.createCriteria()
        Deal dealFound = crit.get { eq ('id', params.id.toLong())} as Deal
        Cart currentCart = Cart.create()
        currentCart.setName("Current Cart")
        currentCart.addToDeals(dealFound)
        currentCart.setDateCreated(new Date())
        currentCart.setQuantities([(dealFound.id as String): 1] as Map<Long, Integer>)
        session.setAttribute("CurrentCart", currentCart)
    }

    private void addDealToAnExistingCartSession() {
        BuildableCriteria crit = Deal.createCriteria()
        Deal dealFound = crit.get { eq ('id', params.id.toLong())} as Deal
        Cart cartSavedInSession = session.getAttribute("CurrentCart") as Cart
        if (isTheSameDeal(cartSavedInSession, dealFound))
            cartSavedInSession.quantities[dealFound.id.toString()] += 1
        else {
            cartSavedInSession.addToDeals(dealFound)
            cartSavedInSession.quantities[dealFound.id.toString()] = 1
        }
        session.setAttribute("CurrentCart", cartSavedInSession)
    }

    private static boolean isTheSameDeal(Cart cartSavedInSession, Deal dealFound) {
        for (Deal deal in cartSavedInSession.getDeals())
        {
            if (deal.id == dealFound.id)
                return true
        }
        return false
    }
}
