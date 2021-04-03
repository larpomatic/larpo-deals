package larpo.deals

import grails.testing.gorm.DomainUnitTest
import org.apache.commons.lang.StringUtils
import spock.lang.Specification

class DealSpec extends Specification implements DomainUnitTest<Deal> {

    void "Test that a name field cannot be nullable"() {
        when: 'name is nullable'
            def deal = new Deal()
            deal.setName(null)
            deal.setDescription("desc")
            deal.setCaption("")
        then: 'validation fails'
            !domain.validate(['name'])
            domain.errors['name'].code == 'nullable'
    }

    void "Test that a description field cannot be nullable"() {
        when: 'description is nullable'
            def deal = new Deal()
            deal.setName("name")
            deal.setDescription(null)
            deal.setCaption("")
        then: 'validation fails'
            !domain.validate(['description'])
            domain.errors['description'].code == 'nullable'
    }

    void "Test that a caption field cannot be nullable"() {
        when: 'caption is nullable'
            def deal = new Deal()
            deal.setName("name")
            deal.setDescription("desc")
            deal.setCaption(null)
        then: 'validation fails'
            !domain.validate(['caption'])
            domain.errors['caption'].code == 'nullable'
    }

    void "Test that a name field cannot be blank"() {
        when: 'name is blank'
            def deal = new Deal()
            deal.setName('')
            deal.setDescription("desc")
            deal.setCaption("")
        then: 'validation fails'
            !deal.validate()
            deal.hasErrors()
            deal.errors['name'].code == 'blank'
    }

    void "Test that a name maxSize must be lower or equal to 100"() {
        when: 'length is greater than 100'
            def deal = new Deal()
            deal.setDescription("desc")
            deal.setCaption("")
            deal.setName(StringUtils.repeat("a", 101))

        then: 'validation fails'
            !deal.validate()
            deal.hasErrors()
            deal.errors['name'].code == 'size.toobig'

        when: 'length is equal to 100'
            deal.setName(StringUtils.repeat("a", 100))

        then: 'validation succeeds'
            deal.validate()
            !deal.hasErrors()
    }

    void "Test that a name minSize must be greater or equal to 2"() {
        when: 'length is less than 2'
            def deal = new Deal()
            deal.setName('a')
            deal.setDescription("desc")
            deal.setCaption("")

        then: 'validation fails'
            !deal.validate()
            deal.hasErrors()
            deal.errors.dump()
            deal.errors['name'].code == 'size.toosmall'

        when: 'length is equal to 2'
            deal.setName("na")

        then: 'validation succeeds'
            deal.validate()
            !deal.hasErrors()
    }

    void "Test that a description field cannot be blank"() {
        when: 'description is blank'
            def deal = new Deal()
            deal.setName('name')
            deal.setDescription("")
            deal.setCaption("")
        then: 'validation fails'
            !deal.validate()
            deal.hasErrors()
            deal.errors['description'].code == 'blank'
    }

    void "Test that a description maxSize must be lower or equal to 255"() {
        when: 'length is greater than 255'
            def deal = new Deal()
            deal.setName("desc")
            deal.setCaption("")
            deal.setDescription(StringUtils.repeat("a", 256))

        then: 'validation fails'
            !deal.validate()
            deal.hasErrors()
            deal.errors['description'].code == 'size.toobig'

        when: 'length is equal to 100'
            deal.setDescription(StringUtils.repeat("a", 255))

        then: 'validation succeeds'
            deal.validate()
            !deal.hasErrors()
    }

    void "Test that a description minSize must be greater or equal to 2"() {
        when: 'length is less than 2'
            def deal = new Deal()
            deal.setName('name')
            deal.setDescription("d")
            deal.setCaption("")

        then: 'validation fails'
            !deal.validate()
            deal.hasErrors()
            deal.errors.dump()
            deal.errors['description'].code == 'size.toosmall'

        when: 'length is equal to 2'
            deal.setDescription("na")

        then: 'validation succeeds'
            deal.validate()
            !deal.hasErrors()
    }
}
