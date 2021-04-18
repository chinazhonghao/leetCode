/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
 var findTargetSumWays = function(nums, target) {
    const dp = [];
    for(let i=0; i<=nums.length; i++) {
      dp.push({});
    }
    dp[0][0] = 1;
    for(let i=0; i<nums.length; i++) {
      const val = dp[i];
      for(let key in val){
        let sum = parseInt(key, 10);
        dp[i+1][sum + nums[i]] = dp[i+1][sum + nums[i]]?dp[i+1][sum + nums[i]]+val[key]:val[key];
        dp[i+1][sum - nums[i]] = dp[i+1][sum - nums[i]]?dp[i+1][sum - nums[i]]+val[key]:val[key];
      }
    }
    return dp[nums.length][target]?dp[nums.length][target]:0;
};