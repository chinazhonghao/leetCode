/**
 * @param {string} s
 * @return {string[][]}
 */
var partition = function(s) {
    var length = s.length, record = [], i=0, j=0;
    for(; i<length; i++) {
      record[i] = [];
    }
    for(i=0; i<length; i++) {
      for(j=0; j<length; j++) {
        record[i][j] = false;
      }
    }
    for(i=0; i<length; i++) {
      for(j=0; j<=i; j++) {
        if(s[j] === s[i] && (i - j < 2 || record[j+1][i-1])){
          record[j][i] = true;
        }
      }
    }

    function _recursive(start, end){
      if(start > end) {
        return [[]];
      }
      var result = [];
      for(var i=start; i<length; i++) {
        if(record[start][i]){
          var current = s.substring(start, i+1);
          var item = _recursive(i+1, end);
          item.forEach(item => item.splice(0, 0, current));
          result.push(...item);
        }
      }
      return result;
    }

    return _recursive(0, length-1);
};
