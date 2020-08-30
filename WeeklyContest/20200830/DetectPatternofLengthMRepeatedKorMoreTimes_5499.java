class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        int length = arr.length;
        if(m*k > length) {
            return false;
        }
        int[] pattern = new int[m];
        for(int i=0; i<length; i++){
            for(int j=0; j<m; j++){
                if(i+j >= length){
                    return false;
                }
                pattern[j] = arr[i+j];
            }
            int repeat = 1;
            for(int x=i+m; x<length; x += m){
                boolean ok = true;
                for(int j=0; j<m; j++){
                    if(x+j>=length || pattern[j] != arr[x+j]){
                        ok = false;
                    }
                }
                if(ok){
                    repeat++;
                    if(repeat >= k){
                        return true;
                    }
                }
                else {
                    break;
                }
            }
        }
        return false;
    }
}