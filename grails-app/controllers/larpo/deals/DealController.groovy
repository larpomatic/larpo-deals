package larpo.deals

class DealController {

    def list()
    {
        List<Deal> deals = Deal.list()

        [deals: deals]
    }
}
