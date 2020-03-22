class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i=0; i<nums.length; i++){
        	List<List<Integer>> newL = new ArrayList<>();
        	for(int j=0; j<result.size(); j++){
        		List<Integer> item = new ArrayList<>();
        		item.addAll(result.get(j));
        		item.add(nums[i]);
        		newL.add(item);
        	}
        	result.addAll(newL);
        }
        return result;
    }
}