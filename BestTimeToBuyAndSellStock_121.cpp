#include <vector>

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int buyDate = -1;
        int sellDate = -1;
        int maxProfit = 0;
        int len = prices.size();
        if(len < 2) {
            return maxProfit;
        }
        buyDate = 0;
        for(sellDate=1; sellDate<prices.size(); sellDate++){
            if(prices[buyDate] > prices[sellDate]){
                buyDate = sellDate;
                continue;
            }
            int profit = this->calculateProfit(prices, buyDate, sellDate);
            maxProfit = maxProfit < profit ? profit : maxProfit;
        }
        return maxProfit;
    }

    int calculateProfit(vector<int>& prices, int buyDate, int sellDate){
        int profit = prices[sellDate] - prices[buyDate];
        return profit > 0 ? profit : 0;
    }
};