class Solution {
    public int integerReplacement(int n) {
        return _recursive(n);
    }

    private int _recursive(int n){
        if(n == 1){
            return 0;
        }
        if((n & 1) == 0){
            return 1 + _recursive(n/2);
        }
        else {
            if(n==Integer.MAX_VALUE){
                return 1 + _recursive(n-1);
            }
            return 1 + Math.min(_recursive(n-1), _recursive(n+1));
        }
    }
}