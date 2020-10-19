class Solution {
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];
        for(int i=0; i<length; i++){
            dp[i][i] = piles[i];
        }
        for(int i=1; i<length; i++){
            for(int j=0; j<length-i; j++){
                int k=j+i;
                dp[i][j] = Math.max(piles[j]-dp[j+1][k], piles[k] - dp[j][k-1]);
            }
        }
        return dp[0][length-1] > 0;
    }
}