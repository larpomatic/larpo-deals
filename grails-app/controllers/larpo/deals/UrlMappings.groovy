package larpo.deals

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(redirect:"/deal/list")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
