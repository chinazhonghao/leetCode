import java.util.ArrayList;

class Solution {
    public List<Integer> grayCode(int n) {
        int count = 1 << n;
        int[] result = new int[count];
        if(n == 0){
            return _toList(result);
        }
        result[1] = 1;
        if(n == 1){
            return _toList(result);
        }
        for(int i=1; i<n; i++){
            int base = 1 << i - 1;
            for(int j=0; j<base; j++){
                result[base+j] = result[base-j-1] + base;
            }
        }
        return _toList(result);
    }
    private List<Integer> _toList(int[] arr){
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            result.add(arr[i]);
        }
        return result;
    }
}