class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int cost = 0;
        int effect = A[0] - 1;
        for(int i=1; i<A.length; i++){
        	cost = Math.max(effect + A[i], cost);
        	effect = Math.max(effect, A[i]) - 1;
        }
        return cost;
    }
}