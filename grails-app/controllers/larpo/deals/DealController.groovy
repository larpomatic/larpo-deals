package larpo.deals

class DealController
{
    // def index() { }

   // def list()
   def list(params)
    {
        // List<Deal> deals = Deal.list(params)
        // println("Hello World")
        def c = Deal.createCriteria()
        def deals = c.list()
        {
            // println (params)
            if (params.search) {
                // println(params.search) //FIME DEBUG PRINT
                ilike("name", "%" + params.search + "%")
            }
        }
        // println(deals) //FIME DEBUG PRINT
        [deals: deals]
    }
}