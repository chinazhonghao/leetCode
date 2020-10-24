class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] counts = new int[l1+1][l2+1];
        for(int i=1; i<=l1; i++){
            for(int j=1; j<=l2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    counts[i][j] = counts[i-1][j-1] + 1;
                }
                else {
                    counts[i][j] = Math.max(counts[i-1][j], counts[i][j-1]);
                }
            }
        }
        return counts[l1][l2];
    }
}