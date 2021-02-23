package larpo.deals

class DealController
{
    // def index() { }

   def list(params)
    {
        // List<Deal> deals = Deal.list(params)
        println("Hello World")
        def c = Deal.createCriteria()
        def deals = c.list()
        {
            // println (params)
            if (params.search)
                ilike("name", params.search)
        }
        [deals: deals]
    }
}
