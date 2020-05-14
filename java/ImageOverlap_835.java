class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        Map<String, Integer> map = new HashMap<>();
        String format = "%d-%d";
        for(int i=0; i<A.length; i++){
            for(int j=0; j<A[0].length; j++){
                if(A[i][j] == 0){
                    continue;
                }
                for(int m=0; m<B.length; m++){
                    for(int n=0; n<B[0].length; n++){
                        if(B[m][n] == 0){
                            continue;
                        }
                        String key = String.format(format, i-m, j-n);
                        if(map.containsKey(key)){
                            map.put(key, map.get(key)+1);
                        }
                        else {
                            map.put(key, 1);
                        }
                    }
                }
            }
        }
        int max = 0;
        for(int v: map.values()){
            max = Math.max(max, v);
        }
        return max;
    }
}