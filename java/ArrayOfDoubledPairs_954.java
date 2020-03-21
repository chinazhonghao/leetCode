class Solution {
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<A.length; i++){
        	if(m.containsKey(A[i])){
        		m.put(A[i], m.get(A[i])+1);
        	}
        	else {
        		m.put(A[i], 1);
        	}
        }
        int[] keys = new int[m.size()];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry: m.entrySet()){
        	keys[index++] = entry.getKey();
        }
        Arrays.sort(keys);
        for(int i=0; i<keys.length; i++){
        	if(m.get(keys[i]) == 0){
        		continue;
        	}
        	int targetKey = 0;
        	if(keys[i] < 0){
        		if(keys[i] % 2 != 0){
        			return false;
        		}
        		targetKey = keys[i] / 2;
        	}
        	else {
        		targetKey = keys[i] * 2;
        	}
        	if(!m.containsKey(targetKey)){
        		return false;
        	}
        	int targetValue = m.get(targetKey);
        	int left = targetValue - m.get(keys[i]);
        	if(left < 0){
        		return false;
        	}
        	m.put(targetKey, left);
        }
        return true;
    }
}