/**
 * @param {number} N
 * @return {number[]}
 */
var beautifulArray = function (N) {
  let result = [1];
  while (result.length < N) {
    let tmp = [];
    let value = 0;
    for (let i = 0; i < result.length; i++) {
      value = result[i] * 2 - 1;
      if (value <= N) {
        tmp.push(value);
      }
    }
    for (let i = 0; i < result.length; i++) {
      value = result[i] * 2;
      if (value <= N) {
        tmp.push(value);
      }
    }
    result = tmp;
  }
  return result;
};
