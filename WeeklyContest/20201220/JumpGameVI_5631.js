/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxResult = function(nums, k) {
    if(nums.length === 1){
        return nums[0];
    }
    var start = 0, exit = false, max = nums[0];
    while(!exit){
        var current = 0, begin=start+1, end=0, last=0, minMaxIndex=start+1, minMax = nums[minMaxIndex];
        if(start+k < nums.length){
            end = start + k
        }
        else {
            end = nums.length-1;
        }
        
        if(end === nums.length - 1){
            exit = true;
        }
        for(var i=begin; i<=end; i++){
            if(nums[i] >= 0){
                current += nums[i];
                last = i;
            }
            if(minMax <= nums[i]){
                minMax = nums[i];
                minMaxIndex = i;
            }
        }
        if(minMax < 0){
            start = minMaxIndex;
            if(exit && minMaxIndex !== nums.length-1){
                max += nums[nums.length-1];
            }
            else {
                max += minMax;
            }
        }
        else {
            start = last;
            max += current;
            if(exit && nums[nums.length - 1] < 0){
                max += nums[nums.length-1];
            }
        }
    }
    return max;
};