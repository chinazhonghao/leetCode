/**
 * @param {string} dominoes
 * @return {string}
 */
var pushDominoes = function(dominoes) {
  var result = dominoes.split(''), start = 0, end = 0, length = result.length;
  while(end < length) {
    if(result[end] === 'L'){
      if(result[start] === '.' || result[start] === 'L'){
        for(var i = start; i<end; i++){
          result[i] = 'L';
        }
      }
      else if(result[start] === 'R'){
        var minus = end - start;
        var l, r;
        if(minus % 2 === 0){
          l = minus / 2 - 1;
        }
        else {
          l = Math.floor(minus / 2);
        }
        r = minus - l;
        for(var i = 0; i <= l; i++){
          result[start + i] = 'R';
        }
        for(var i = 0; i<=l; i++){
          result[start + r + i] = 'L';
        }
      }
      start = end;
    }
    else if(result[end] === 'R'){
      if(result[start] === 'R'){
        for(var i=start; i<end; i++){
          result[i] = 'R';
        }
      }
      start = end;
    }
    end++;
  }
  if(start < end && result[start] === 'R'){
    for(var i=start+1; i<end; i++){
      result[i] = 'R';
    }
  }
  return result.join('');
};

console.log(pushDominoes("R.......L.R........."));
