package larpo.deals

class BootStrap {

    def init = { servletContext ->
        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed porta laoreet laoreet. Morbi nec lectus neque. Etiam quis porttitor risus. Morbi fringilla mauris auctor ornare dignissim. Maecenas maximus facilisis tortor nec tempus."
        Random random = new Random()
        new Deal('https://i.ibb.co/zbWYqCJ/Truck-Cars.jpg', 'Truck', loremIpsum, random.nextInt(10000)).save(failOnError: true)
        new Deal('https://i.ibb.co/bWhWsy1/CarsBus1.jpg', 'Bus', loremIpsum, random.nextInt(10000)).save(failOnError: true)
        new Deal('https://i.ibb.co/Ln9PF1v/CarsBus2.jpg', 'Bus', loremIpsum, random.nextInt(10000)).save(failOnError: true)
    }

    def destroy = {
    }
}
