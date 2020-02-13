class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int length = A.length;
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<length; i++){
        	m.put(A[i], i);
        }

        Map<Integer, Integer> record = new HashMap<>();
        int result = 0;
        for(int k=0; k<length; k++){
        	for(int j=0; j<k; j++){
        		int i = m.getOrDefault(A[k] - A[j], -1);
        		if(i>=0 && i<j){
        			int l = record.getOrDefault(i*length+j, 2) + 1;
        			record.put(j*length+k, l);
        			result = Math.max(result, l);
        		}
        	}
        }
        return result;
    }
}