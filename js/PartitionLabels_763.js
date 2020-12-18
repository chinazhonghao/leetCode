/**
 * @param {string} S
 * @return {number[]}
 */
var partitionLabels = function(S) {
  var result = [], record = new Array(26), i=0, begin = 'a'.codePointAt(0), length = S.length;
  for(i=0; i<26; i++){
    record[i] = 0;
  }
  function _recursive(current){
    var item = record.slice(), start=current, end=length, code = 0;
    while(end > start){
      if(S[end-1] !== S[start]){
        code = S[end-1].charCodeAt(0) - begin;
        if(item[code] === 0){
          item[code] = end - 1;
        }
      }
      else {
        break;
      }
      end--;
    }

    var max = end-1;
    start++;
    while(start < max+1){
      code = S[start].charCodeAt(0) - begin;
      max = Math.max(max, item[code]);
      start++;
    }
    return max;
  }
  
  var current = 0, end = 0;
  while(current < S.length){
    end = _recursive(current);
    result.push(end - current + 1);
    current = end + 1;
  }
  return result;
};
