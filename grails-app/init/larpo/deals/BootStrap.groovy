package larpo.deals
import java.util.Random


class BootStrap {

    def init = { servletContext ->

        Random random = new Random()
        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ultricies blandit felis et tempus. Duis in erat eu eros semper tempor et nec leo. Nulla eget lorem et odio facilisis suscipit ac eu risus. Phasellus convallis sed dolor vel gravida. ";

        new Deal('https://cdn.shopify.com/s/files/1/2122/5885/products/GarbageTruckwithFaceOrnament-OR1346_582x582.jpg?v=1502727672', 'Truck', loremIpsum, random.nextInt(10000)).save(failOnError: true);
        new Deal('https://images-na.ssl-images-amazon.com/images/I/61kHFl7bYRL._AC_SX425_.jpg', 'Bus', loremIpsum, random.nextInt(10000)).save(failOnError: true);
        new Deal('https://m.media-amazon.com/images/I/519gkH3zvOL._ML160_.jpg', 'Bus', loremIpsum, random.nextInt(10000)).save(failOnError: true);
    }
    def destroy = {
    }
}
