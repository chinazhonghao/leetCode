class Solution {
    public int findMinFibonacciNumbers(int k) {
        int count = 0;
        int f1 = 1;
        int f2 = 1;
        while(f2 <= k){
            int temp = f1;
            f1 = f2;
            f2 = temp + f1;
        }

        while(f1 > 0){
            if(f1 <= k){
                k -= f1;
                count++;
            }
            int temp = f1;
             f1 = f2 - f1;
             f2 = temp;
        }
        return count;
    }
}