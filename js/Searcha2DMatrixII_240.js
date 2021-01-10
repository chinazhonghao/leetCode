/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */

function findTarget(nums, left, right, target) {
  if(left > right){
    return false;
  }
  var mid = (left + right) >> 1;
  if(nums[mid] === target){
    return true;
  } else if(nums[mid] < target){
    return findTarget(nums, mid+1, right, target);
  } else {
    return findTarget(nums, left, mid-1, target);
  }
}

var searchMatrix = function (matrix, target) {
  var rows = matrix.length, cols = matrix[0].length;
  for(var i=0; i<rows; i++) {
    if(matrix[i][0] > target){
      return false;
    } else if(matrix[i][cols-1] < target){
      continue;
    } else if(findTarget(matrix[i], 0, cols-1, target)){
      return true;
    }
  }
  return false;
};