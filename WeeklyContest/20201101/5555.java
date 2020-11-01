class Solution {
    public int countVowelStrings(int n) {
        int[][] m = new int[n][5];
        for(int j=0; j<5; j++){
            m[0][j] = 1;
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<5; j++){
                int value = 0;
                for(int k=j; k<5; k++){
                    value += m[i-1][k];
                }
                m[i][j] = value;
            }
        }
        int result = 0;
        for(int j=0; j<5; j++){
            result += m[n-1][j];
        }
        return result;
    }
}