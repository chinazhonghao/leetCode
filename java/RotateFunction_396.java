class Solution {
    public int maxRotateFunction(int[] A) {
        if(A.length < 1){
            return 0;
        }
        int sumA = 0, base = 0;
        for(int i=0; i<A.length; i++){
            sumA += A[i];
            base += A[i] * i;
        }
        int prev = base, max = base;
        for(int i=1; i<A.length; i++){
            int current = prev + sumA - A.length * A[A.length - i];
            max = Math.max(current, max);
            prev = current;
        }
        return max;
    }
}