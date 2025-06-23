package Array.Easy;

public class IMPBestTimeToBuyAndSellStock {
    public static void main(String[] args) {
       int[] prices = {1,6,4,3,7};
       System.out.println("Maximum profit " + maxProfit(prices));

       // Medium problem
        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150
        System.out.println("Maximum profit II " + maxProfit2(prices));
    }

    private static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if(price <  minPrice) {
                minPrice = price;
            } else {
                maxProfit = maxProfit + (price - minPrice);
                minPrice = price;
            }
        }
        return maxProfit;
    }

    public static int maxProfit(int[] prices) {
       int maxProfit = 0;
       int minPrice =  Integer.MAX_VALUE;

       for(int price : prices) {
           if(price <  minPrice) {
               minPrice = price;
           } else {
               maxProfit = Math.max(maxProfit,price - minPrice);
           }
       }
       return maxProfit;
    }
}
