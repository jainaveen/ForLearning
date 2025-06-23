package DynamicProgramming.Medium.Stocks;

public class DemoStocks {

    public static void main(String[] args) {
        BestTimeToBuyAndSell stock = new BestTimeToBuyAndSell();
        System.out.println(stock.maxProfit(new int[]{7,2,4,5,1,3,6,4}));

        System.out.println(stock.totalProfit(new int[]{1,2,3,4,5}));

        System.out.println(stock.buyAndSellProfit(new int[]{3,2,6,5,0,3}));

    }
}
