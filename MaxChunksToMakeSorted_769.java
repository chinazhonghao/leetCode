class Solution {
    public int maxChunksToSorted(int[] arr) {
    	int length = arr.length;
    	int count = 0;
    	int[] s = new int[length];
        int min = arr[0];
        int max = arr[0];
        for(int i=1; i<length; i++){
        	if(max > arr[i]){
        		min = Math.min(min, arr[i]);
        	}
        	else {
        		boolean ok = true;
        		for(int j=0; j<count; j++){
        			if(min < s[j]){
        				count = j+1;
        				s[j] = max;
        				ok = false;
        				break;
        			}
        		}
        		if(ok){
        			s[count++] = max;
        		}
        		min = arr[i];
        		max = arr[i];
        	}
        }
        boolean ok = true;
		for(int j=0; j<count; j++){
			if(min < s[j]){
				count = j+1;
				s[j] = max;
				ok = false;
				break;
			}
		}
		if(ok){
			return count+1;
		}
        return count;
    }
}
