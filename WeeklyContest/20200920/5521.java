class Solution {
    public int maxProductPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int max = Integer.MIN_VALUE;
        int[] currentResult = new int[2];
        int MAX = 1000000007;
        Set<Integer> current = new HashSet<>();
        Set<Integer> down = new HashSet<>();
        Set<Integer> right = new HashSet<>();
        for(int i=rows; i>0; i--){
            for(int j=cols; j>0; j--){
                int current = grid[i-1][j-1];
                if(current == 0){
                    result[i-1][j-1][0] = 0;
                    result[i-1][j-1][1] = 0;
                }
                else {
                    currentResult[0] = Integer.MIN_VALUE;
                    currentResult[0] = Integer.MIN_VALUE;
                    if(i < rows){
                        int[] _result = result[i][j-1];
                        if(current > 0){
                            currentResult[0] = (_result[0] * current) % MAX;
                            currentResult[1] = (_result[1] * current) % MAX;
                        }
                        else {
                            currentResult[0] = (_result[1] * current) % MAX;
                            currentResult[1] = (_result[0] * current) % MAX;
                        }
                    }

                    if(j < cols){
                        int[] _result = result[i-1][j];
                        if(current > 0){
                            currentResult[0] =
                        }
                    }
                }
            }
        }
        return result[0][0];
    }
}