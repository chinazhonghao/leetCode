/**
 * @param {number} n
 * @return {number}
 */
var numTrees = function(n) {
    let m = {};
    function _recursive(start, end){
        if(start >= end){
            return 1;
        }
        if(!!m[start+"-"+end]){
            return m[start+"-"+end];
        }
        let count = 0;
        for(let i=start; i<=end; i++){
            let left = _recursive(start, i-1);
            let right = _recursive(i+1, end);
            count += (left * right);
        }
        m[start+"-"+end] = count;
        return count;
    }

    return _recursive(1, n);
};