/*
 * @Description  : 
 * @Date         : 2021-02-25 19:25:38
 * @Author       : haozhong<haozhong@tencent.com>
 * @LastEditors  : haozhong<haozhong@tencent.com>
 * @LastEditTime : 2021-02-25 20:32:29
 * @FilePath     : /LeetCode/js/UglyNumberIII_1201.js
 */
/**
 * @param {number} n
 * @param {number} a
 * @param {number} b
 * @param {number} c
 * @return {number}
 */
var nthUglyNumber = function (n, a, b, c) {
  function _lcm(m, n) {
    let a = Math.max(m, n), b = Math.min(m, n);
    while (b > 0) {
      let c = a % b;
      a = b;
      b = c;
    }
    return a;
  }
  let m = a * b / _lcm(a, b);
  m = m * c / _lcm(m, c);
  let l1 = a * b / _lcm(a, b), l2 = a * c / _lcm(a, c), l3 = b * c / _lcm(b, c);
  function _count(k) {
    return Math.floor(k / a) + Math.floor(k / b) + Math.floor(k / c) - Math.floor(k / l1) - Math.floor(k / l2) - Math.floor(k / l3) + Math.floor(k / m);
  }
  let left = 1, right = 20000000000;
  while (left < right) {
    let mid = Math.floor((left + right) / 2);
    if (_count(mid) < n) {
      left = mid + 1;
    } else {
      right = mid;
    }
  }
  return left;
};