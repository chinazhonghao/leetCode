class Solution {
    public int minOperations(int n) {
        int min = 1;
        int max = 2*(n-1)+1;
        int balance = (min + max) >> 1;
        int diff = balance - min;
        if((diff & 1) == 0){
            return (diff * ((n+1) >> 1)) >> 1;
        }
        else {
            return ((diff + 1) * (n >> 1))>>1;
        }
    }
}