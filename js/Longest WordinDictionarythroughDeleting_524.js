/**
 * @param {string} s
 * @param {string[]} d
 * @return {string}
 */
var findLongestWord = function (s, d) {
  var begin = 'a'.codePointAt(0), i=0, j=0;
  var record = makeRecord(s);
  function makeRecord(word){
    var record = new Array(word.length), i=0;
    record[word.length-1] = new Array(26);
    for(i=0; i<26; i++){
      record[word.length-1][i] = 0;
    }
    for(i=word.length-2; i>=0; i--){
      record[i] = record[i+1].slice();
      record[i][word[i+1].codePointAt(0)-begin]++;
    }
    return record;
  }
  function isSubstring(word, wordRecord, index, begin) {
    if(begin >= word.length){
      return true;
    }
    if(index >= s.length){
      return false;
    }
    if(word[begin] !== s[index]){
      return isSubstring(word, wordRecord, index+1, begin);
    }
    for(var i=0; i<26; i++){
      if(record[index][i] < wordRecord[begin][i]){
        return false;
      }
    }
    return isSubstring(word, word, index+1, begin+1);
  }

  d.sort((a, b) => {
    if (a.length > b.length) {
      return -1;
    }
    else if (a.length < b.length) {
      return 1;
    }
    else if (a > b) {
      return 1;
    }
    else if (a < b) {
      return -1;
    }
    else {
      return 0;
    }
  });
  for (let word of d) {
    let wordRecord = makeRecord(word);
    if (isSubstring(word, wordRecord, 0, 0)) {
      return word;
    }
  }
  return "";
};