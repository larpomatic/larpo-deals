package larpo.deals

class BootStrap {

    def init = { servletContext ->
        new Deal('http://2.bp.blogspot.com/-O8H8VwjsgHQ/UTSApHY3M_I/AAAAAAAAAhU/AlSeJgJ3ijE/s400/monster-motorbike-1-big.jpg', 'Truck', loremIpsum, random.nextInt(10000)).save(failOnError: true);
        new Deal('http://4.bp.blogspot.com/-Van_nK7u00s/UVxQXKZvJJI/AAAAAAAABdg/NzAitf6enl4/s1600/21e004.jpg', 'Bus', loremIpsum, random.nextInt(10000)).save(failOnError: true);
        new Deal('http://4.bp.blogspot.com/-Ho7vuFhRA6g/UVxQYXKCx8I/AAAAAAAABdo/wWbB5_E1z7o/s1600/36012.jpg', 'Bus', loremIpsum, random.nextInt(10000)).save(failOnError: true);
    }
    def destroy = {
    }
}
