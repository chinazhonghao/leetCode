class Solution {
    public int minIncrementForUnique(int[] A) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<A.length; i++){
        	if(m.containsKey(A[i])){
        		m.put(A[i], m.get(A[i])+1);
        	}
        	else {
        		m.put(A[i], 1);
        	}
        }

        int token = 0;
        int index = 0;
        int result = 0;
        while(!m.isEmpty() || token > 0){
        	if(m.containsKey(index)){
        		int val = m.get(index);
        		if(val > 1){
        			token += val - 1;
        			result -= index * (val - 1);
        		}
        		m.remove(index);
        	}
        	else {
        		if(token > 0){
        			token--;
        			result += index;
        		}
        	}
        	index++;
        }
        return result;
    }
}