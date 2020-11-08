/**
 * @param {number} n
 * @return {number}
 */
var getMaximumGenerated = function(n) {
    let record = new Array(n);
    if(n < 1){
        return 0;
    }
    record[0] = 0;
    record[1] = 1;
    let max = 1;
    for(let i=2; i<=n; i++){
        if((i & 1) == 0){
            record[i] = record[i/2];
        }
        else {
            let index = parseInt(i/2);
            record[i] = record[index] + record[index + 1];
            max = Math.max(record[i], max);
        }
    }
    return max;
};