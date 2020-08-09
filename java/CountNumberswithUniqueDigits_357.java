class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] counts = new int[9];
        counts[0] = 1;
        for(int i=1; i<9; i++){
            counts[i] = 9;
            for(int j=1; j<i; j++){
                counts[i] *= (10 - j);
            }
        }
        int result = 0;
        for(int i=0; i<=n; i++){
            result += counts[i];
        }
        return result;
    }
}