/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canPartition = function(nums) {
    var sum = nums.reduce((result, item) => result + item, 0);
    if(sum & 1 !== 0){
      return false;
    }
    var halfSum = sum / 2;
    var dps = new Array(halfSum+1);
    for(var i =0; i<dps.length; i++){
      dps[i] = false;
    }
    dps[0] = true;
    for(var i = 0; i < nums.length; i++){
      for(var j = halfSum; j>= nums[i]; j--){
        dps[j] = dps[j] || dps[j - nums[i]];
      }
    }
    return dps[halfSum];
};