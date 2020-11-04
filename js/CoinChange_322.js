/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {
    let dp = [0];
    for(let i=1; i<=amount; i++){
        dp[i] = amount + 1;
    }
    for(let i=1; i<=amount; i++){
        for(let j=0; j<coins.length; j++){
            if(i === coins[j]){
                dp[i] = 1;
            }
            else if(i > coins[j]){
                dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
            }
        }
    }
    if(dp[amount] < amount+1){
        return dp[amount];
    }
    return -1;
};