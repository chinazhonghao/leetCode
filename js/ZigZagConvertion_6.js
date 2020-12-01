/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {
    let result = [];
    if(numRows < 2){
        return s;
    }
    for(let i=0; i<numRows; i++){
        result.push([]);
    }
    let current = 0, step = 1;
    for(let i=0; i<s.length; i++){
        result[current].push(s[i]);
        current += step;
        if(current >= numRows){
            current = numRows - 2;
            step = -1;
        }
        else if(current < 0){
            current = 1;
            step = 1;
        }
    }
    console.log(result);
    return result.flat().join("");
};