class Solution {
    public int minCost(String s, int[] cost) {
        int result = 0;
        int length = s.length();
        char prev = s.charAt(0);
        int size = 1;
        for(int i=1; i<length; i++){
            if(s.charAt(i) == prev){
                size++;
            }
            else {
                if(size > 1){
                    int end = i-1;
                    int max = cost[end];
                    for(int j=end; j>end-size; j--){
                        result += cost[j];
                        max = Math.max(cost[j], max);
                    }
                    result -= max;
                }
                prev = s.charAt(i);
                size = 1;
            }
        }
        if(size > 1){
            int end = length-1;
            int max = cost[end];
            for(int j=end; j>end-size; j--){
                result += cost[j];
                max = Math.max(cost[j], max);
            }
            result -= max;
        }
        return result;
    }
}