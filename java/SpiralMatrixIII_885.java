class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int size = R * C;
        int[][] result = new int[size][2];
        int index = 1;
        result[0][0] = r0;
        result[0][1] = c0;
        int step = 1;
        while(index < size){
            for(int i=0; i<step; i++){
                if(_isValid(r0, ++c0, R, C)){
                    result[index][0] = r0;
                    result[index][1] = c0;
                    index++;
                }
            }
            for(int i=0; i<step; i++){
                if(_isValid(++r0, c0, R, C)){
                    result[index][0] = r0;
                    result[index][1] = c0;
                    index++;
                }
            }
            step++;
            for(int i=0; i<step; i++){
                if(_isValid(r0, --c0, R, C)){
                    result[index][0] = r0;
                    result[index][1] = c0;
                    index++;
                }
            }
            for(int i=0; i<step; i++){
                if(_isValid(--r0, c0, R, C)){
                    result[index][0] = r0;
                    result[index][1] = c0;
                    index++;
                }
            }
            step++;
        }
        return result;
    }

    public boolean _isValid(int x, int  y, int R, int C){
        if(x >=0 && x < R && y >=0 && y < C){
            return true;
        }
        return false;
    }
}