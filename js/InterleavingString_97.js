/**
 * @param {string} s1
 * @param {string} s2
 * @param {string} s3
 * @return {boolean}
 */
 var isInterleave = function(s1, s2, s3) {
    const l1 = s1.length, l2 = s2.length, l3 = s3.length;
    if(l1 + l2 !== l3) {
      return false;
    }
    const dp = [];
    for(let i=0; i<l1; i++) {
      const item = [];
      for(let j=0; j<l2; j++) {
        item.push(true);
      }
      dp.push(item);
    }
    for(let i=0; i<l1; i++) {
      for(let j=0; j<l2; j++) {
        let res = false;
        if(i > 0) {
          res = dp[i-1][j] && (s1[i] === s3[i+j-1]);
        }
        if(j > 0){
          res = res ? res : dp[i][j-1] && (s2[j] === s3[i+j-1]);
        }
        dp[i][j] = res;
      }
    }
    return dp[l1-1][l2-1];
};
