class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] counts = new int[n];
        int maxCount = 0;
        List<Integer> result = new ArrayList<>();
        counts[rounds[0]-1]=1;
        for(int i=1; i<rounds.length; i++){
            int end = rounds[i];
            int start = rounds[i-1];
            if(end < start){
                end += n;
            }
            for(int j=start+1; j<=end; j++){
                if(j <= n){
                    counts[j-1]++;
                }
                else {
                    counts[j-n-1]++;
                }
            }
        }
        for(int i=0; i<n; i++){
            maxCount = Math.max(maxCount, counts[i]);
        }
        for(int i=0; i<n; i++){
            if(counts[i] == maxCount){
                result.add(i+1);
            }
        }
        return result;
    }
}