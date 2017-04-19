public class AppleStocks {
    public static int getMaxProfit(int[] prices) {
        int savedMin = Math.min(prices[0],prices[1]);
        int savedMax = Math.max(prices[0],prices[1]);
        int runningMin = savedMin;
        int runningMax = savedMax;

        for (int i = 2; i < prices.length; i++) {
            int price = prices[i];
            if (price < runningMin) {
             	runningMin = price;
                runningMax = price;
            } else if (price > runningMax) {
                runningMax = price;
                int localProfit = runningMax - runningMin;
                if (localProfit > savedMax - savedMin) {
                	savedMax = runningMax;
                    savedMin = runningMin;
                }
            }
        }
        return savedMax - savedMin;
    }


    public static void main(String[] args) {

        int[] stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};
		    int profit = getMaxProfit(stockPricesYesterday);

        System.out.println(profit);

    }
}