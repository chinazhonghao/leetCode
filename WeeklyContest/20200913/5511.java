class Solution {
    public int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int count = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(mat[i][j] == 1){
                    boolean isOk = true;
                    for(int k=0; k<cols; k++){
                        if(k!=j && mat[i][k]==1){
                            isOk = false;
                            break;
                        }
                    }
                    if(isOk){
                        for(int k=0; k<rows; k++){
                            if(k!=i && mat[k][j]==1){
                                isOk = false;
                                break;
                            }
                        }
                    }
                    if(isOk){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}