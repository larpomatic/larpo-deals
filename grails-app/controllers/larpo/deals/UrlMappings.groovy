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

        "/larpo-deals/test"(view:"/test")

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}