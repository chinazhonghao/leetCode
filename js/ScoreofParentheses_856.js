/**
 * @param {string} S
 * @return {number}
 */
function _g(p) {
  return {
    contains: [],
    parent: p || null,
  };
}

var scoreOfParentheses = function (S) {
  let root = _g();
  let stack = [], character, current = root;
  for (let i = 0; i < S.length; i++) {
    character = S[i];
    if (character === '(') {
      current = _g(current);
      stack.push(current);
    } else {
      let val = 0;
      current = stack.pop();
      for(let j=0; j<current.contains.length; j++){
        val += current.contains[j];
      }
      if(val === 0) {
        val = 1;
      } else {
        val *= 2;
      }
      current = current.parent;
      current.contains.push(val);
    }
  }

  let sum = 0;
  for (let i = 0; i < root.contains.length; i++) {
    sum += root.contains[i];
  }
  return sum;
};