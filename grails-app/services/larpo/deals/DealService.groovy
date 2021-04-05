package larpo.deals

import grails.gorm.transactions.Transactional

@Transactional
class DealService {

    /**
     * basic bubble sort
     * @return the list of deals, sorted by number of deals (descending), then, by name (ascending)
     */
    static Deal[] getDealsSorted(Cart cart) {
        if (cart == null){
            return []
        }

        boolean isSorted = false
        Integer[] lutNbDeals = cart.getLutNbDeals()
        Deal[] deals = cart.getDeals()

        while (!isSorted) {
            isSorted = true
            for (int i = 0; i < deals.size() - 1; i++) {
                if (mustSwapDeals(lutNbDeals, deals, i)) {
                    Deal tmp = deals[i]
                    deals[i] = deals[i + 1]
                    deals[i + 1] = tmp
                    isSorted = false
                }
            }
        }

        return deals;
    }

    private static boolean mustSwapDeals(Integer[] lutNbDeals, Deal[] deals, Integer i){
        return (lutNbDeals[deals[i].id as Integer] < lutNbDeals[deals[i + 1].id as Integer]
                || (deals[i].name > deals[i + 1].name
                    && lutNbDeals[deals[i].id as Integer] == lutNbDeals[deals[i + 1].id as Integer]))
    }
}
