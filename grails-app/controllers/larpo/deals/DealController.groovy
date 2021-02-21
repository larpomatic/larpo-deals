package larpo.deals

class DealController
{
    // def index() { }

    def list()
    {
        List<Deal> deals = Deal.list()

        [deals: deals]
    }
}
