/**
 * @param {number[][]} intervals
 * @return {number[]}
 */
var findRightInterval = function(intervals) {
  var length = intervals.length, result = [], current, pos = {}, i=0, keys = [], left, right, mid, index;
  for(i=0; i<length; i++) {
    current = intervals[i][0];
    pos[current] = i;
    keys.push(current);
  }
  keys.sort((a, b) => a - b);
  for(var i=0; i<length; i++) {
    current = intervals[i][1];
    left = 0, right = keys.length-1;
    index = undefined;
    while(left <= right){
      mid = Math.floor((left + right) / 2);
      if(keys[mid] < current){
        left = mid + 1;
      }
      else if(keys[mid] > current){
        index = pos[keys[mid]];
        right = mid - 1;
      }
      else {
        index = pos[keys[mid]];
        break;
      }
    }
    if(index !== undefined && intervals[index] && intervals[index][0] >= current){
      result.push(index);
    }
    else {
      result.push(-1);
    }
  }
  return result;
};
