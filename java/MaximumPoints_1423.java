class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left=0, right=0;
        for(int i=0; i<k; i++){
            left += cardPoints[i];
        }
        int result = left;
        int length = cardPoints.length;
        for(int i=1; i<=k; i++){
            right += cardPoints[length-i];
            left -= cardPoints[k-i];
            result = Math.max(result, right+left);
        }
        return result;
    }
}