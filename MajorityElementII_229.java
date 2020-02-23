class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int length = nums.length;
        int limit = length / 3;
        List<Integer> result = new ArrayList<>();
        int[] m = new int[2];
        int[] counts = new int[2];
        for(int i=0; i<length; i++){
        	if(nums[i] == m[0]){
        		counts[0]++;
        	}
        	else if(nums[i] == m[1]){
        		counts[1]++;
        	}
        	else if(counts[0] == 0){
        		m[0] = nums[i];
        		counts[0] = 1;
        	}
        	else if(counts[1] == 0){
        		m[1] = nums[i];
        		counts[1] = 1;
        	}
        	else {
        		counts[0]--;
        		counts[1]--;
        	}
        }

        counts[0] = 0;
        counts[1] = 0;
        for(int i=0; i<length; i++){
        	if(nums[i] == m[0]){
        		counts[0]++;
        	}
        	else if(nums[i] == m[1]){
        		counts[1]++;
        	}
        }
        for(int i=0; i<2; i++){
        	if(counts[i] > limit){
        		result.add(m[i]);
        	}
        }
        return result;
    }
}