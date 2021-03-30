package larpo.deals

class BootStrap {

    def init = { servletContext ->
        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed porta laoreet laoreet. Morbi nec lectus neque. Etiam quis porttitor risus. Morbi fringilla mauris auctor ornare dignissim. Maecenas maximus facilisis tortor nec tempus."
        Random random = new Random()
        Deal deal1 = new Deal('https://i.ibb.co/YcFWs6h/Cars-Truck1.png', 'Truck', loremIpsum, random.nextInt(10000)).save(failOnError: true)
        Deal deal2 = new Deal('https://i.ibb.co/xCyqKX1/CarsBus1.png', 'Bus', loremIpsum, random.nextInt(10000)).save(failOnError: true)
        Deal deal3 = new Deal('https://i.ibb.co/MPxvQ68/CarsBus2.png', 'Bus', loremIpsum, random.nextInt(10000)).save(failOnError: true)

        Cart cart = new Cart("Lovely Cart", new Date())
        cart.addToDeals(deal1)
        cart.addToDeals(deal2)
        Integer[] lutNbDeals = [0, 1, 1, 0]
        cart.setLutNbDeals(lutNbDeals)
        cart.save(failOnError: true)

        Cart cart2 = new Cart("Lovely Cart", new Date())
        cart2.addToDeals(deal1)
        lutNbDeals = [0, 1, 0, 0]
        cart2.setLutNbDeals(lutNbDeals)
        cart2.save(failOnError: true)
    }

    def destroy = {
    }
}
