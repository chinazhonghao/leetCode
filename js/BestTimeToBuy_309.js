/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    if(prices.length < 2){
        return 0;
    }
    let s0 = [0], s1 = [-prices[0]], s2 = [0];
    for(let i=1; i<prices.length; i++){
        s0[i] = Math.max(s0[i-1], s2[i-1]);
        s1[i] = Math.max(s0[i-1]-prices[i], s1[i-1]);
        s2[i] = s1[i-1]+prices[i];
    }
    return Math.max(s0[prices.length-1], s1[prices.length-1], s2[prices.length-1]);
};