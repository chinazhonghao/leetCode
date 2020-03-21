class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int length = nums.length;
        if(length % k != 0){
        	return false;
        }

        TreeMap<Integer, Integer> m = new TreeMap<>();
        for(int i=0; i<length; i++){
        	if(m.containsKey(nums[i])){
        		m.replace(nums[i], m.get(nums[i]) + 1);
        	}
        	else {
        		m.put(nums[i], 1);
        	}
        }

        int cycle = (int)(length / k);
        for(int i=0; i<cycle; i++){
        	Integer key = m.firstKey();
        	int val = m.get(key);
        	if(val == 1){
        		m.remove(key);
        	}
        	else {
        		m.replace(key, val-1);
        	}
        	for(int j=1; j<k; j++){
        		if(m.containsKey(key+j)){
        			int tmp = m.get(key+j);
        			if(tmp == 1){
        				m.remove(key+j);
        			}
        			else {
        				m.replace(key+j, tmp-1);
        			}
        		}
        		else {
        			return false;
        		}
        	}
        }
        return true;
    }
}