/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var maxSlidingWindow = function(nums, k) {
    if(k < 2){
      return nums;
    }
    if(nums.length < k){
      return [Math.max(...nums)];
    }
    let buffer = [], result = [], max = nums[0], current = 0;;
    for(var i = 0; i < k-1; i++){
      buffer.push(nums[i]);
      if(nums[i] > max){
        current = i;
        max = nums[i];
      }
    }
    for(i=k-1; i<nums.length; i++){
      buffer.push(nums[i]);
      if(nums[i] > max){
        max = nums[i];
        current = i;
        result.push(max);
      }
      else if(current>=i-(k-1)) {
        result.push(max);
      }
      else {
        max = buffer[0];
        current = i-k+1;
        for(var j=1; j<k; j++){
          if(buffer[j] > max){
            max = buffer[j];
            current = j+i-k+1;
          }
        }
        result.push(max);
      }
      buffer.shift();
    }
    return result;
};