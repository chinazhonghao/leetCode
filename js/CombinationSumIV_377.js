/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var combinationSum4 = function(nums, target) {
    nums = nums.sort((a, b) => a - b);
    var cache = new Array(target), count, minus;
    for(var i=1; i<=target; i++){
        count = 0;
        for(var j=0; j<nums.length; j++){
            minus = i - nums[j];
            if(minus > 0){
                count += cache[minus-1];
            }
            else if(minus === 0){
                count++;
            }
            else {
                break;
            }
        }
        cache[i-1] = count;
    }
    return cache[target-1];
};