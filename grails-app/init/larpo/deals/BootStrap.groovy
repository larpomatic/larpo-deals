package larpo.deals

class BootStrap {

    def init = { servletContext ->
        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed porta laoreet laoreet. Morbi nec lectus neque. Etiam quis porttitor risus. Morbi fringilla mauris auctor ornare dignissim. Maecenas maximus facilisis tortor nec tempus."
        Random random = new Random()

        //Trucks
        Deal deal1 = new Deal('https://i.ibb.co/YcFWs6h/Cars-Truck1.png', 'Red truck', loremIpsum, random.nextInt(10000)).save(failOnError: true)
        new Deal('https://i.ibb.co/C6GjDdc/Cars-Blue-Truck.png', 'Blue truck', loremIpsum, random.nextInt(10000)).save(failOnError: true)
        //Buses
        Deal deal2 = new Deal('https://i.ibb.co/s2hSrZZ/CarsBus1.png', 'Yellow bus', loremIpsum, random.nextInt(10000)).save(failOnError: true)
        new Deal('https://i.ibb.co/MPxvQ68/CarsBus2.png', 'Red bus', loremIpsum, random.nextInt(10000)).save(failOnError: true)
        //Cars
        new Deal('https://i.ibb.co/mJJB4Fg/RedCar.png', 'Red car', loremIpsum, random.nextInt(10000)).save(failOnError: true)
        new Deal('https://i.ibb.co/12gFBpt/GreyCar.png', 'Grey car', loremIpsum, random.nextInt(10000)).save(failOnError: true)

        Cart cart = new Cart("Lovely Cart", new Date())
        cart.addToDeals(deal1)
        cart.addToDeals(deal2)
        Integer[] lutNbDeals = [null, 1, 0, 1, 0, 0, 0]
        cart.setLutNbDeals(lutNbDeals)
        cart.save(failOnError: true)

        Cart cart2 = new Cart("Amazing Cart", new Date())
        cart2.addToDeals(deal1)
        lutNbDeals = [null, 1, 0, 0, 0, 0, 0]
        cart2.setLutNbDeals(lutNbDeals)
        cart2.save(failOnError: true)
    }

    def destroy = {
    }
}
