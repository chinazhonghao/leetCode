/**
 * @param {number[][]} points
 * @param {number} K
 * @return {number[][]}
 */
var kClosest = function (points, K) {
  let dists = [];
  points.forEach(item => {
    dists.push({
      d: item[0] * item[0] + item[1] * item[1],
      o: item
    });
  });
  let length = points.length, l = 0, r = length - 1;
  function _swap(i, j) {
    tmp = dists[i];
    dists[i] = dists[j];
    dists[j] = tmp;
  }

  function _divide(l, r) {
    const base = dists[l];
    while (l < r) {
      while (l < r && base.d < dists[r].d) {
        r--;
      }
      _swap(l, r);
      while (l < r && base.d >= dists[l].d) {
        l++;
      }
      _swap(l, r);
    }
    dists[r] = base;
    return r;
  }

  let index = 0;
  K--;
  while(true){
    index = _divide(l, r);
    if(index === K) {
      break;
    } else if(index > K) {
      r = index - 1;
    } else {
      l = index + 1;
    }
  }
  let result = [];
  for(let i=0; i<=index; i++){
    result.push(dists[i].o);
  }
  return result;
};

