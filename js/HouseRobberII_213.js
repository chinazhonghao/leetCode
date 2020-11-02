/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    var records = [nums[0]];
    if(nums.length < 2){
        return nums[0];
    }
    return Math.max(robbers(nums.slice(0, nums.length-1)), robbers(nums.slice(1)));
};

function robbers(nums){
    var result = 0;
    if(nums.length < 2){
        return nums[0];
    }
    result = Math.max(nums[0], nums[1]);
    var records = [nums[0], result];
    for(var i=2; i<nums.length; i++){
        result = Math.max(nums[i]+records[i-2], records[i-1]);
        records.push(result);
    }
    return result;
}