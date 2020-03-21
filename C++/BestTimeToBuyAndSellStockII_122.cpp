class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int buyDate = 0;
        int sellDate = 0;
        int sumProfit = 0;
        int len = prices.size();
        if(len < 2){
            return sumProfit;
        }

        for(int currentDate = 1; currentDate < len; currentDate++){
            if(prices[currentDate] < prices[sellDate]){
                int sellProfit = prices[sellDate] - prices[buyDate];
                if(sellProfit > 0){
                    sumProfit += sellProfit;
                }
                buyDate = currentDate;
            }
            sellDate = currentDate;
        }
        sumProfit += (prices[sellDate] - prices[buyDate]);
        return sumProfit;
    }
};