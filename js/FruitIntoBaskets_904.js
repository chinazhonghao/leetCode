/**
 * @param {number[]} tree
 * @return {number}
 */
var totalFruit = function(tree) {
  var count = 0, max = 0, right = 0, flag = {}, type = 0;
  for(right = 0; right < tree.length; right++){
    var current = tree[right];
    if(flag[current] !== undefined){
      flag[current] = right;
      count++;
    }
    else {
      if(type === 2){
        var prev = tree[right - 1], keys = Object.keys(flag);
        max = Math.max(max, count);
        var r = (keys[0] == prev) ? keys[1] : keys[0];
        var pos = flag[r];
        flag = {
          [prev]: right-1,
          [current]: right
        };
        count = right - pos;
        type = 2;
      }
      else {
        flag[current] = right;
        type++;
        count++;
      }
    }
  }
  return Math.max(max, count);
};
