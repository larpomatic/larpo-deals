package larpo.deals

class BootStrap {

    def init = { servletContext ->
        String loremIpsum ="Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                "when an unknown printer took a galley of type and scrambled it to make."
        Random random = new Random()
        Deal TruckDeal =  new Deal('https://i.pinimg.com/originals/48/eb/29/48eb293fd3ca02788c7744e527e1444e.jpg', 'Truck', loremIpsum, random.nextInt(10000))
        TruckDeal.save(failOnError: true)
        Deal BusDeal1 = new Deal('https://images.newschoolers.com/images/17/00/54/06/70/540670_400w_600h.jpeg', 'Bus', loremIpsum, random.nextInt(10000))
        BusDeal1.save(failOnError: true)
        Deal BusDeal2 = new Deal('https://auto.vercity.ru/img/magazine/old/20213.jpg', 'Bus', loremIpsum, random.nextInt(10000))
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