/**
 * @param {string} input
 * @return {number[]}
 */
var diffWaysToCompute = function (input) {
  let result = [], length = input.length;
  for (let i = 0; i < length; i++) {
    if (input[i] === '-' || input[i] === '+' || input[i] === '*') {
      let left = diffWaysToCompute(input.substring(0, i));
      let right = diffWaysToCompute(input.substring(i + 1));
      for (let m = 0; m < left.length; m++) {
        for (let n = 0; n < right.length; n++) {
          if (input[i] === '-') {
            result.push(left[m] - right[n]);
          } else if (input[i] === '+') {
            result.push(left[m] + right[n]);
          } else {
            result.push(left[m] * right[n]);
          }
        }
      }
    }
  }
  if (result.length === 0) {
    result.push(parseInt(input));
  }
  return result;
};