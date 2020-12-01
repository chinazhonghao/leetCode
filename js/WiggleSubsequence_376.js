/**
 * @param {number[]} nums
 * @return {number}
 */
var wiggleMaxLength = function(nums) {
    if(nums.length < 2){
        return nums.length;
    }
    var minus = [], count = 0, prev;
    for(var i=1; i<nums.length; i++){
        minus.push(nums[i] - nums[i-1]);
    }
    i=0;
    while(i<minus.length && minus[i] === 0){
        i++;
    }
    prev = minus[i];
    if(prev && prev !== 0){
        count++;
    }
    for(; i<minus.length; i++){
        if(minus[i] === 0){
            continue;
        }
        if(prev * minus[i] < 0){
            count++;
            prev = minus[i];
        }
    }
    return count+1;
};