package DynamicProgramming.Medium.Stocks;

import java.util.*;

public class BestTimeToBuyAndSell {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currProfit;
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            buyPrice = buyPrice < prices[i] ? buyPrice : prices[i];
            currProfit = prices[i] - buyPrice;
            maxProfit = Math.max(maxProfit,currProfit);
        }
        return maxProfit;
    }

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    public int totalProfit(int[] prices) {
        int totalProfit = 0;
        int currProfit;

        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i] < prices[i+1]) {
                currProfit = prices[i+1] - prices[i];
                totalProfit = totalProfit + currProfit;
            }

        }
        return totalProfit;
    }

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
    public int buyAndSellProfit(int[] prices) {
        int totalProfit = 0;
        int trans1;
        int count = 0;
        int minVal = Integer.MAX_VALUE;
        boolean flag = false;
        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i] < prices[i+1]) {
                count++;
                trans1 = prices[i+1] - prices[i];
                if(flag && count > 2) {
                    totalProfit -= minVal;
                    minVal = Integer.MAX_VALUE;
                }
                minVal= Math.min(minVal,trans1);

                totalProfit += trans1;
            } else {
                flag = true;
            }
        }
        return totalProfit;
    }

}
