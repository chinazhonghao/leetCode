/**
 * @param {number[]} nums
 * @return {number}
 */
 var lengthOfLIS = function(nums) {
    const lens = [1];
    for(let i=1; i<nums.length; i++) {
      let max = 1;
      for(let j=0; j<i; j++){
        if(nums[i] > nums[j]) {
          max = Math.max(max, lens[j]+1);
        }
      }
      lens.push(max);
    }
    return Math.max(...lens);
};