/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxResult = function(nums, k) {
    var max = 0, record = [];
    for(var i=nums.length-1; i>=0; i--){
        max = nums[i] + (record.length > 0?nums[record[0]]:0);
        while(record.length > 0 && max > nums[record[record.length-1]]){
            record.pop();
        }
        record.push(i);
        if(record.length > 0 && i+k<=record[0]){
            record.shift();
        }
        nums[i] = max;
    }
    return max;
};
