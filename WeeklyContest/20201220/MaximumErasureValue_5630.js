/**
 * @param {number[]} nums
 * @return {number}
 */
var maximumUniqueSubarray = function(nums) {
    var i=0, start = 0, sums = new Array(nums.length + 1);
    sums[0] = 0;
    for(i=0; i<nums.length; i++){
        sums[i+1] = sums[i] + nums[i];
    }
    i = 0;
    var obj = {}, max = 0, current = 0, val = 0, next = 0;
    while(i < nums.length){
        val = nums[i];
        if(obj[val] !== undefined){
            next = obj[val] + 1;
            current = sums[i+1] - sums[next];
            for(var j=start; j<next; j++){
                obj[nums[j]] = undefined;
            }
            start = next;
        }
        else {
            obj[val] = i;
            current += val;
            max = Math.max(max, current);
            i++;
        }
    }
    return max;
};