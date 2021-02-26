/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function (nums, k) {
  function _divide(l, r){
    let base = nums[l];
    while(l <= r){
      while(l <= r && nums[l] >= base) {
        l++;
      }
      while(l <= r && nums[r] < base) {
        r--;
      }
      let tmp = nums[l];
      nums[l] = nums[r];
      nums[r] = tmp;
      l++, r--;
    }
    nums[r] = base;
    return r;
  }

  function _recursive(l, r) {
    let index = _divide(l, r);
    if(index === k){
      return index;
    } else if(index > k) {
      return _recursive(l, index);
    } else {
      return _recursive(index, r);
    }
  }
  console.log(_recursive(0, nums.length-1));
};

console.log(findKthLargest([3,2,1,5,6,4],2));