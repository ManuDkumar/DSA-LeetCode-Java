class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int buy;
        buy = prices[0];
        int maximumprofit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < buy){
                buy = prices[i];
            }      
            else {
                int profit = prices[i] - buy;
                if(profit > maximumprofit){
                    maximumprofit=profit;
                }
            }
        }
        return maximumprofit;
    }
}
