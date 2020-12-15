/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var characterReplacement = function(s, k) {
  let length = s.length, left=0, right=0, max=0, current=0, record = new Array(26);
  for(let i=0; i<record.length; i++){
    record[i] = 0;
  }
  const head = 'A'.charCodeAt(0);
  record[s.charCodeAt(right)-head]++;
  while(right < length){
    for(let i=0; i<record.length; i++){
      current = Math.max(current, record[i]);
    }
    if(current + k > right - left){
      right++;
      record[s.charCodeAt(right)-head]++;
    }
    else {
      record[s.charCodeAt(left)-head]--;
      left++;
    }
    max = Math.min(length, Math.max(max, current + k));
  }
  return max;
};
