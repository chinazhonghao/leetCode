/**
 * @param {number[][]} matrix
 */
var NumMatrix = function(matrix) {
    this.matrix = matrix;
    this.m = new Array(matrix.length+1);
    if(this.matrix.length < 1){
        return;
    }
    for(var i=0; i<=matrix.length; i++){
        this.m[i] = new Array(matrix[0].length+1);
    }
    for(var i=0; i<this.m.length; i++){
        for(var j=0; j<this.m[i].length; j++){
            this.m[i][j] = 0;
        }
    }
    for(var i=0; i<matrix.length; i++){
        for(var j=0; j<matrix[i].length; j++){
            this.m[i+1][j+1] = this.matrix[i][j] + this.m[i+1][j] + this.m[i][j+1] - this.m[i][j];
        }
    }
};

/** 
 * @param {number} row1 
 * @param {number} col1 
 * @param {number} row2 
 * @param {number} col2
 * @return {number}
 */
NumMatrix.prototype.sumRegion = function(row1, col1, row2, col2) {
    row2++;
    col2++;
    row1++;
    col1++;
    return this.m[row2][col2] - this.m[row1-1][col2] - this.m[row2][col1-1] + this.m[row1-1][col1-1];
};

/** 
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = new NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */