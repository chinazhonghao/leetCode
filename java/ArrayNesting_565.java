class Solution {
    public int arrayNesting(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        int result = 0;
        for(int i=0; i<nums.length; i++){
        	if(flag[i]){
        		continue;
        	}
        	int count = 1;
        	flag[i] = true;
        	int current = nums[i];
        	while(!flag[current]){
        		count++;
        		current = nums[current];
        	}
        	result = Math.max(result, count);
        }
        return result;
    }
}