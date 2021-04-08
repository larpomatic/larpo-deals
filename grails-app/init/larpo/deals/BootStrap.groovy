package larpo.deals
//Init database with 3 deals and 2 carts
class BootStrap {

    def init = { servletContext ->

        Deal test = new Deal('https://static.turbosquid.com/Preview/001313/910/DZ/_200.jpg', 'Truck', "loremIpsum",new Random().nextInt(10000)).save(failOnError: true)
        Deal test2 = new Deal('https://www.capbus.fr/var/ezwebin_site/storage/images/mediatheque/images/logo-tps-reel/286674-1-fre-FR/logo-tps-reel_medium.png', 'Bus', "loremIpsum", new Random().nextInt(10000)).save(failOnError: true)
        Deal test3 = new Deal('https://lignes-agglo.fr/wp-content/uploads/2019/02/ic-busscolaire.png', 'Bus', "loremIpsum", new Random().nextInt(10000)).save(failOnError: true)

        Cart a = new Cart('lovely', new Date())
        a.addToDeals(test)
        a.addToDeals(test2).save(failOnError: true)
        Cart b = new Cart('amazing', new Date())
        b.addToDeals(test3).save(failOnError: true)
    }
    def destroy = {
    }
}
