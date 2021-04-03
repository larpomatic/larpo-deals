package larpo.cart

import grails.testing.gorm.DomainUnitTest
import larpo.deals.Deal
import org.apache.commons.lang.StringUtils
import spock.lang.Specification

class CartSpec extends Specification implements DomainUnitTest<Cart> {

    void "Test that a name field cannot be nullable"() {
        when: 'name is nullable'
            def cart = new Cart()
            cart.setName(null)
        then: 'validation fails'
            !domain.validate(['name'])
            domain.errors['name'].code == 'nullable'
    }

    void "Test that a name field cannot be blank"() {
        when: 'name is blank'
            def cart = new Cart()
        cart.setName('')
        then: 'validation fails'
            !cart.validate()
        cart.hasErrors()
        cart.errors['name'].code == 'blank'
    }

    void "Test that a name maxSize must be lower or equal to 100"() {
        when: 'length is greater than 100'
        def cart = new Cart()
        cart.setName(StringUtils.repeat("a", 101))

        then: 'validation fails'
        !cart.validate()
        cart.hasErrors()
        cart.errors['name'].code == 'size.toobig'

        when: 'length is equal to 100'
        cart.setName(StringUtils.repeat("a", 100))

        then: 'validation succeeds'
        cart.validate()
        !cart.hasErrors()
    }

    void "Test that a name minSize must be greater or equal to 2"() {
        when: 'length is less than 2'
        def cart = new Cart()
        cart.setName('a')

        then: 'validation fails'
        !cart.validate()
        cart.hasErrors()
        cart.errors.dump()
        cart.errors['name'].code == 'size.toosmall'

        when: 'length is equal to 2'
        cart.setName("na")

        then: 'validation succeeds'
        cart.validate()
        !cart.hasErrors()
    }
}
