class Solution {
    public int movesToMakeZigzag(int[] nums) {
    	if(nums.length < 2){
    		return 0;
    	}
    	List<Integer> target = new ArrayList<>();
    	for(int i=1; i<nums.length; i+=2){
    		if(i==1){
    			target.add(nums[i]-1);
    		}
    		else {
    			target.add(Math.min(nums[i]-1, nums[i-2]-1));
    		}
    	}
    	if((nums.length%2) != 0 && nums.length > 2){
    		target.add(nums[nums.length-2]-1);
    	}
    	int counts = 0;
    	int index = 0;
    	for(int i=0; i<nums.length; i+=2){
    		if(nums[i] > target.get(index)){
    			counts += (nums[i] - target.get(index));
    		}
    		index++;
    	}

    	int counts2 = 0;
    	target.clear();
    	for(int i=1; i<nums.length; i+=2){
            if(i+1 < nums.length){
                target.add(Math.min(nums[i-1]-1, nums[i+1]-1));
            }
            else {
                target.add(nums[i-1]-1);
            }
    	}
    	index = 0;
    	for(int i=1; i<nums.length; i+=2){
    		if(nums[i] > target.get(index)){
    			counts2 += (nums[i] - target.get(index));
    		}
    		index++;
    	}
        return Math.min(counts, counts2);
    }
}