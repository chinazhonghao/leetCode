/**
 * @param {number[]} citations
 * @return {number}
 */
var hIndex = function (citations) {
  var N = citations.length, left=0, right = N-1, middle = 0;
  while(left <= right) {
    middle = (left + right) >> 1;
    if(citations[middle] >= (N - middle)){
      right = middle - 1;
    }
    else if(citations[middle] < (N - middle)){
      left = middle + 1;
    }
  }
  return N - left;
};