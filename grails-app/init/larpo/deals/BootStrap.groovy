package larpo.deals

import java.util.Random


class BootStrap {

    def init = { servletContext ->

        Random random = new Random()

        Deal truck = new Deal('https://shinemaster.net/wp-content/uploads/2016/04/red-truck.png', 'Truck', "Magnifique camion d'occasion, comme neuf, magnifique chassie équipée de transmission hydraulique, gente en acier chromé, remorque intégrée, vendu avec les roues de secours intégrés, frais de port a ajouté", random.nextInt(10000)).save(failOnError: true);
        Deal Bus1 = new Deal('https://assets.stickpng.com/images/580b585b2edbce24c47b2bf6.png', 'Bus', "véhicule de transport routier de voyageurs en milieux urbain/périurbain et suburbain. C'est l'un des principaux types de véhicules employé dans les transports en commun.", random.nextInt(10000)).save(failOnError: true);
        Deal Bus2 = new Deal('http://pngimg.com/uploads/bus/bus_PNG8636.png', 'a better bus', "le même Bus, mais en mieux", random.nextInt(10000)).save(failOnError: true);
        new Deal('https://www.pngarts.com/files/4/Monster-Truck-PNG-Image-Transparent.png','Monster-truck','Je vends ce monster truck 4x4, réviser pour la vente, Courrone centrale en alu Carrosserie à du vécu mais fonctionnelle Lipo 4s 3300mah Envoie possible à vos frais Annonce visible voiture disponible', random.nextInt(10000)).save(failOnError: true);
        new Deal('https://www.pngarts.com/files/4/Monster-Truck-PNG-Photo.png','Monster monstre-truck',"Un monstre monster truck, sinon c'est le même", random.nextInt(10000)).save(failOnError: true);
        new Deal('http://pngimg.com/uploads/truck/truck_PNG16275.png','another truck','Un autre camion, comme le premier', random.nextInt(10000)).save(failOnError: true);
        new Deal('https://i.pinimg.com/originals/c7/ae/a1/c7aea143f5bde830845eea627c27627c.png','More truck','Toujours plus de camion', random.nextInt(10000)).save(failOnError: true);
        new Deal('https://purepng.com/public/uploads/large/purepng.com-trucktruckpickup-truckbig-trucktrucks-1701527681534kbj6m.png','Big truck',"C'est un camion comme les autres, mais il est plus gros", random.nextInt(10000)).save(failOnError: true);
        new Deal('https://i.pinimg.com/originals/73/15/c5/7315c5c87a5f2741efe6afffb21f00ef.png','Jackie Car',"Y'a des néon et des lumiéres, y'a la sono, ça c'est de nono, parceque avec le casque bas on entend rien hein", random.nextInt(10000)).save(failOnError: true);

        new Cart("lovely train", new Date(), [truck, Bus1]).save(failOnError: true);
        new Cart("tin tin tin", new Date(), [Bus2]).save(failOnError: true);
    }
    def destroy = {
    }
}
