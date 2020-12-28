/**
 * @param {number[]} arr
 * @return {number}
 */
var longestMountain = function(arr) {
    var start = 0, current = 0, direction = 0, max = 0;
    for(var current = 1; current < arr.length; current++) {
      var pre = arr[current-1], now = arr[current];
      if(direction === 0){
        if(pre < now){
          continue;
        }
        else if(pre > now){
          if(current-1 > start){
            direction = 1;
            continue;
          }
          else {
            start = current;
          }
        }
        else {
          if(direction === 1){
            max = Math.max(max, current - start);
          }
          start = current;
        }
      }
      else {
        if(pre > now){
          continue;
        }
        else if(pre < now){
          max = Math.max(max, current - start);
          start = current - 1;
          direction = 0;
        }
        else {
          max = Math.max(max, current - start);
          start = current;
          direction = 0;
        }
      }
    }
    if(direction === 1){
      max = Math.max(max, current - start);
    }
    return max;
};