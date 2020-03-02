class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
        return _combination(candidates, target, 0);
    }

    public List<List<Integer>> _combination(int[] candidates, int target, int start){
    	int length = candidates.length;
    	List<List<Integer>> result = new ArrayList<>();
    	for(int i=start; i<length; i++){
    		int left = target - candidates[i];
    		if(left < 0){
    			break;
    		}
    		else if(left == 0){
    			List<Integer> tmp = new ArrayList<>();
    			tmp.add(candidates[i]);
    			result.add(tmp);
    			break;
    		}
    		List<List<Integer>> l = _combination(candidates, left, i);
    		for(List<Integer> item: l){
    			item.add(candidates[i]);
    			result.add(item);
    		}
    	}
    	return result;
    }
}