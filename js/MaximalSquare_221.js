/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function(matrix) {
    if(matrix.length < 1){
        return 0;
    }
    var a = [];
    for(var i=0; i<matrix.length; i++){
        var item = [];
        for(var j=0; j<matrix[i].length; j++){
            item.push(0);
        }
        a.push(item);
    }
    var max = 0;
    for(var i=0; i<matrix[0].length; i++){
        if(matrix[0][i] == 1){
            a[0][i] = 1;
            max = 1;
        }
    }
    for(var i=0; i<matrix.length; i++){
        if(matrix[i][0] == 1){
            a[i][0] = 1;
            max = 1;
        }
    }
    var val = 0;
    for(var i=1; i<matrix.length; i++){
        for(var j=1; j<matrix[i].length; j++){
            if(matrix[i][j] == 1){
                val = Math.min(a[i-1][j-1], a[i-1][j], a[i][j-1]);
                a[i][j] = val + 1;
                max = Math.max(max, a[i][j]);
            }
        }
    }
    return max*max;
};