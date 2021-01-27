/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNonDuplicate = function (nums) {
  var left = 0, right = nums.length - 1, mid = 0, leftNum = 0, rightNum = 0;
  if(nums.length === 1){
    return nums[0];
  }
  while (left < right + 2) {
    mid = Math.floor((left + right) / 2);
    leftNum = mid - left;
    rightNum = right - mid;
    if(nums[mid] === nums[mid-1]){
      if(leftNum & 1 === 1) {
        left = mid + 1;
      }
      else {
        right = mid - 2;
      }
    }
    else if(nums[mid] === nums[mid+1]){
      if(rightNum & 1 === 1) {
        right = mid - 1;
      }
      else {
        left = mid + 2;
      }
    }
    else {
      return nums[mid];
    }
  }
  if(nums[left] === nums[left+1]) {
    return nums[right];
  }
  return nums[left];
};

console.log(singleNonDuplicate([1,1,2,2,3]));