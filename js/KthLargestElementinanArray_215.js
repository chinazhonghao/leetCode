/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function (nums, k) {
  function _divide(l, r) {
    let base = nums[l], tmp = l;
    while (l < r) {
      while (l < r && base > nums[r]) {
        r--;
      }
      while (l < r && base <= nums[l]) {
        l++;
      }
      _swap(l, r);
    }
    _swap(tmp, r);
    return r;
  }

  function _swap(i, j) {
    let tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  function _recursive(l, r) {
    let index = _divide(l, r);
    if (index === k) {
      return index;
    } else if (index > k) {
      return _recursive(l, index - 1);
    } else {
      return _recursive(index + 1, r);
    }
  }
  k--;
  return nums[_recursive(0, nums.length - 1)];
};
