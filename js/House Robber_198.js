/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
  if (nums.length < 1) {
    return 0;
  }
  if (nums.length < 2) {
    return nums[0];
  }
  let a = nums[0], b = nums[1], c = 0;
  for(let i=2; i<nums.length; i++) {
    let tmp = Math.max(c+nums[i], a+nums[i]);
    c = a;
    a = b;
    b = tmp;
  }
  return Math.max(a, b, c);
};
