class Solution {
    public int stoneGameV(int[] stoneValue) {
        int length = stoneValue.length;
        if(length < 2){
            return 0;
        }
        int[] sums = new int[length+1];
        for(int i=0; i<length; i++){
            sums[i+1] = sums[i] + stoneValue[i];
        }
        return _dfs(sums, 0, length, new HashMap<>());
    }

    private int _dfs(int[] sums, int start, int end, Map<String, Integer> m){
        if(start == end){
            return 0;
        }
        String key = start + "-" + end;
        if(m.containsKey(key)){
            return m.get(key);
        }
        int result = 0;
        for(int i=start+1; i<end; i++){
            int left = sums[i] - sums[start];
            int right = sums[end] - sums[i];
            int current = 0;
            if(left < right){
                current = left + _dfs(sums, start, i, m);
            }
            else if(right < left){
                current = right + _dfs(sums, i, end, m);
            }
            else {
                current = left + Math.max(_dfs(sums, start, i, m), _dfs(sums, i, end, m));
            }
            result = Math.max(current, result);
        }
        m.put(key, result);
        return result;
    }
}