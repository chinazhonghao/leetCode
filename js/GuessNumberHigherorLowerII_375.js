/**
 * @param {number} n
 * @return {number}
 */
var getMoneyAmount = function(n) {
    let dp = new Array(n+1);
    for(let i=0; i<=n; i++){
        for(let j=0; j<=n; j++){
            dp[i][j] = 0;
        }
    }
    return _recursive(1, n);
    function _recursive(start, end){
        if(start >= end){
            return 0;
        }
        if(dp[start][end] > 0){
            return dp[start][end];
        }
        let min = n*n;
        for(let k=start; k<=end; k++){
            let result = k + Math.max(_recursive(start, k-1), _recursive(k+1, end));
            min = Math.min(min, result);
        }
        dp[start][end] = min;
        return min;
    }
};