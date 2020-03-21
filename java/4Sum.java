class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        int last = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0; i<length; i++){
        	if(nums[i] == last){
        		continue;
        	}
        	last = nums[i];
        	for(int j=i+1; j<length; j++){
        		int m = j+1, n = length-1;
        		while(m < n){
        			int sum = nums[i] + nums[j] + nums[m] + nums[n];
        			if(sum == target){
        				List<Integer> tmp = new ArrayList<>();
        				tmp.add(nums[i]);
        				tmp.add(nums[j]);
        				tmp.add(nums[m]);
        				tmp.add(nums[n]);
        				if(!result.contains(tmp)){
        					result.add(tmp);
        				}
        			}
        			if(sum > target){
        				n--;
        			}
        			else {
        				m++;
        			}
        		}
        	}
        }
        return result;
    }
}