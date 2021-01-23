/**
 * @param {number[]} arr
 * @param {number} k
 * @param {number} x
 * @return {number[]}
 */
var findClosestElements = function (arr, k, x) {
  var left = 0, right = arr.length - 1, mid = 0;
  while (left < right) {
    if(arr[left] >= x){
      right = left;
      break;
    }
    else if(arr[right] <= x){
      left = right;
      break;
    }
    mid = Math.floor((left + right) / 2);
    if(arr[mid] > x){
      right = mid - 1;
    }
    else if(arr[mid] < x){
      left = mid + 1;
    }
    else {
      left = right = mid;
      break;
    }
  }
  var ds = [Number.MAX_SAFE_INTEGER, Math.abs(arr[left] - x), Number.MAX_SAFE_INTEGER];
  if(left - 1 >= 0){
    ds[0] = Math.abs(arr[left - 1]-x);
  }
  if(left + 1 < arr.length){
    ds[2] = Math.abs(arr[left + 1]-x);
  }
  var min = Math.min(...ds);
  for(let i=0; i<3; i++){
    if(ds[i] === min){
      left = (left - 1) + i;
      break;
    }
  }
  
  right = left + 1;
  for(; k>0; k--){
    if(left < 0){
      right++;
      continue;
    }
    else if(right >= arr.length){
      left--;
      continue;
    }
    if(Math.abs(arr[left] - x) < Math.abs(arr[right] - x)){
      left--;
    }
    else if(Math.abs(arr[right] - x) < Math.abs(arr[left] - x)){
      right++;
    }
    else {
      left--;
    }
  }
  return arr.slice(left+1, right);
};
