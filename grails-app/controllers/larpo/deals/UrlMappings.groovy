package larpo.deals

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/larpo-deals/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/larpo-deals/GN"(view:"/GN") // Easter Egg ;)

        // "/"(view:"/index")
        "/"(redirect:"/larpo-deals/deal/list")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}