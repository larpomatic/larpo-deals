package larpo.deals

class BootStrap {

    def init = { servletContext ->
        String loremIpsum ="Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                "when an unknown printer took a galley of type and scrambled it to make."
        Random random = new Random()
        Deal TruckDeal =  new Deal('http://2.bp.blogspot.com/-O8H8VwjsgHQ/UTSApHY3M_I/AAAAAAAAAhU/AlSeJgJ3ijE/s400/monster-motorbike-1-big.jpg', 'Truck', loremIpsum, random.nextInt(10000))
        TruckDeal.save(failOnError: true)
        Deal BusDeal1 = new Deal('http://4.bp.blogspot.com/-Van_nK7u00s/UVxQXKZvJJI/AAAAAAAABdg/NzAitf6enl4/s1600/21e004.jpg', 'Bus', loremIpsum, random.nextInt(10000))
        BusDeal1.save(failOnError: true)
        Deal BusDeal2 = new Deal('http://4.bp.blogspot.com/-Ho7vuFhRA6g/UVxQYXKCx8I/AAAAAAAABdo/wWbB5_E1z7o/s1600/36012.jpg', 'Bus', loremIpsum, random.nextInt(10000))
        BusDeal2.save(failOnError: true)

        Date date = new Date().parse("dd.MM.yyy HH:mm:ss", "28.02.2014 17:52:00")
        Cart LovelyCart = new Cart(date, "Lovely Cart").addToDeals(BusDeal1).addToDeals(TruckDeal).save(failOnError: true)
        LovelyCart.dateCreated = date
        LovelyCart.cost = CartService.cost(LovelyCart)
        LovelyCart.save(failOnError: true)
        Cart AmazingCart = new Cart(date, "Amazing Cart").addToDeals(BusDeal2).save(failOnError: true)
        AmazingCart.dateCreated = date
        AmazingCart.cost = CartService.cost(AmazingCart)
        AmazingCart.save(failOnError: true)
    }

    def destroy = {
    }
}
