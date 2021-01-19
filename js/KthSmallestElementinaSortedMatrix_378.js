/**
 * @param {number[][]} matrix
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function(matrix, k) {
  var rows = matrix.length, cols = matrix[0].length, left = matrix[0][0], right = matrix[rows - 1][cols - 1], middle = 0;
  while(left <= right) {
    middle = Math.floor((left + right) / 2);
    var count = _count(middle);
    if(count >= k){
      right = middle - 1;
    }
    else if(count < k) {
      left = middle + 1;
    }
  }

  function _count(target){
    var count = 0;
    for(var i=0; i<rows; i++){
      var left = 0, right = cols - 1, middle = 0, line = matrix[i];
      if(target < line[left]){
        break;
      }
      else if(target > line[right]){
        count += cols;
        continue;
      }
      while(left <= right) {
        middle = Math.floor((left + right) / 2);
        if(line[middle] <= target){
          left = middle + 1;
        }
        else {
          right = middle - 1;
        }
      }
      count += left;
    }
    return count;
  }

  return left;
};

