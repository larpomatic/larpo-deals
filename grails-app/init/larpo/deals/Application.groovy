package larpo.deals

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

class Application extends GrailsAutoConfiguration {
    static void NewCurrentCart(session) {
        if (session.isNew())
            session["CurrentCart"] = new Cart(new Date(), "Current Cart")//.save(failOnError: true, flush: true)
    }

    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }
}