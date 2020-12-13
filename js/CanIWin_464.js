/**
 * @param {number} maxChoosableInteger
 * @param {number} desiredTotal
 * @return {boolean}
 */
var canIWin = function(maxChoosableInteger, desiredTotal) {
  if(maxChoosableInteger >= desiredTotal){
    return true;
  }
  if(maxChoosableInteger * (maxChoosableInteger + 1) < 2 * desiredTotal){
    return false;
  } 
  var flags = {};
  var win = (target, flag) => {
    if(flags[flag] !== undefined){
      return flags[flag];
    }
    for(var i = 0; i <maxChoosableInteger; i++){
      var state = 1 << i;
      if((state & flag) > 0){
        continue;
      }
      if(target <= i+1){
        return true;
      }
      var result = win(target - i - 1, state | flag);
      flags[state | flag] = result;
      if(!result){
        return true;
      }
    }
    return false;
  };
  return win(desiredTotal);
};