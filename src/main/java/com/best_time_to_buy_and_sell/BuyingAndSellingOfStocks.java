package com.best_time_to_buy_and_sell;
import java.util.List;

/**
 * for getting maximum profit can be make.
 */
public class BuyingAndSellingOfStocks {
    /**
     * to determine high profit can be make.
     * @param stockPrice list stockPrice.
     * @param transactionFee trasaction fee of stock buy and sell.
     * @return return max profit after fee deduction.
     */
    public int maxProfit(final List<Integer> stockPrice,
                         final int transactionFee) {
        int size = stockPrice.size();
        if (size <= 1) {
            return 0;
        }
        int buying = 0;
        int selling = -1 * stockPrice.get(0);
        for (int indexOfstockPrice = 1;
             indexOfstockPrice < size; indexOfstockPrice++) {
            buying = Math.max(buying, selling
                    + stockPrice.get(indexOfstockPrice)
                    - transactionFee);
            selling = Math.max(selling, buying
                    - stockPrice.get(indexOfstockPrice));
        }
        return buying;
    }
}
