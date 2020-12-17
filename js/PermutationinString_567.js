/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var checkInclusion = function(s1, s2) {
    var len1 = s1.length, record = new Array(26), begin = 'a'.codePointAt(0), i=0;
    for(i=0; i<26; i++){
      record[i] = 0;
    }
    for(i=0; i<len1; i++) {
      record[s1[i].codePointAt(0) - begin]++;
    }
    for(i=0; i<s2.length-len1; i++){
      var copy = record.slice(), left=len1;
      for(var j=0; j<len1; j++){
        var c = s2[i+j].codePointAt(0) - begin;
        if(copy[c] <= 0){
          break;
        }
        copy[c]--;
        left--;
      }
      if(left === 0){
        return true;
      }
    }
    return false;
};