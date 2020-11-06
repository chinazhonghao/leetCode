/**
 * @param {number} num
 * @return {number[]}
 */
var countBits = function(num) {
    let result = [0];
    let base = 1, left = 0;
    for(let i=1; i<=num; i++){
        left = i - base;
        if(left < base){
            result.push(result[left] + 1);
        }
        else {
            base = base << 1;
            left = i - base;
            result.push(result[left] + 1);
        }
    }
    return result;
};