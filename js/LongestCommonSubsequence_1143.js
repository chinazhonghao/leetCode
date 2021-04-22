/*
 * @Description  : 
 * @Date         : 2021-04-22 13:20:00
 * @Author       : haozhong<haozhong@tencent.com>
 * @LastEditors  : haozhong<haozhong@tencent.com>
 * @LastEditTime : 2021-04-22 13:23:44
 */
/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function (text1, text2) {
  const len1 = text1.length, len2 = text2.length;
  const dp = [];
  for(let i=0; i<=len1; i++) {
    dp.push([]);
  }
  for(let i=0; i<=len1; i++) {
    for(let j=0; j<=len2; j++) {
      dp[i].push(0);
    }
  }
  for(let i=1; i<=len1; i++) {
    for(let j=1; j<=len2; j++) {
      if(text1[i-1] === text2[j-1]) {
        dp[i][j] = dp[i-1][j-1] + 1;
      } else {
        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
      }
    }
  }
  return dp[len1][len2];
};