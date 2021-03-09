package larpo.deals

class DealController {
    def list() {
        if (params.search) {
            def c = Deal.createCriteria()
            def deals = c.list
                    {
                        like('name', '%' + params.search + '%')
                    }
            [deals: deals]
        }
        else {
            [deals: Deal.list()]
        }
    }
}
