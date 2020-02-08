class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int[] sums = new int[A.length+1];
        for(int i=1; i<A.length+1; i++){
        	sums[i] = A[i-1] + sums[i-1];
        }
        int count = 0;
        int[] record = new int[K];
        for(int i=0; i<A.length+1; i++){
        	record[(sums[i]%K + K) % K]++;
        }
        for(int i=0; i<K; i++){
        	count += record[i]*(record[i]-1) / 2;
        }
        return count;
    }
}