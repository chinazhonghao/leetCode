/**
 * @param {number[]} arr
 * @param {number} target
 * @return {number}
 */
var threeSumMulti = function(arr, target) {
    const LIMIT = 1000000007;
    let records = {}, counts = 0;
    for(let i=0; i<arr.length; i++) {
      counts = (counts + (records[target - arr[i]] || 0)) % LIMIT;
      for(let j=0; j<i; j++){
        let vals = arr[i] + arr[j];
        if(records[vals]) {
          records[vals] += 1;
        } else {
          records[vals] = 1;
        }
      }
    }
    return counts;
};