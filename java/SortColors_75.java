class Solution {
    public void sortColors(int[] nums) {
        int[] record = new int[3];
        int length = nums.length;
        for(int i=0; i<length; i++){
        	record[nums[i]]++;
        }
        int k = 0;
        for(int i=0; i<3; i++){
        	for(int j=0; j<record[i]; j++){
        		nums[k++] = i;
        	}
        }
    }
}