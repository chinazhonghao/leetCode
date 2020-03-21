class Solution {
    public int numFriendRequests(int[] ages) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<ages.length; i++){
        	if(m.containsKey(ages[i])){
        		m.put(ages[i], m.get(ages[i])+1);
        	}
        	else {
        		m.put(ages[i], 1);
        	}
        }
        int length = m.size();
        int[] A = new int[length];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry: m.entrySet()){
        	A[index++] = entry.getKey();
        }
        Arrays.sort(A);
        int result = 0;
        for(int i=length-1; i>=0; i--){
        	int count = m.get(A[i]);
        	if(A[i]*0.5+7 < A[i]){
        		result += count * (count-1);
        	}
        	for(int j=i-1; j>=0; j--){
        		if(A[i]*0.5+7>=A[j]){
        			break;
        		}
        		int c = m.get(A[j]);
        		result += count * c;
        	}
        }
        return result;
    }
}