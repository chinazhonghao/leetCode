class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return _recursive(candidates, 0, target);
    }

    public List<List<Integer>> _recursive(int[] candidates, int start, int target){
    	List<List<Integer>> result = new ArrayList<>();
    	if(start >= candidates.length || target < candidates[start]){
    		return result;
    	}
    	for(; start<candidates.length; start++){
    		List<Integer> l = new ArrayList<>();
    		int goal = target - candidates[start];
    		if(goal == 0){
    			l.add(candidates[start]);
    			if(!result.contains(l)){
    				result.add(l);
    			}
    		}
    		List<List<Integer>> tmp = _recursive(candidates, start+1, goal);
    		for(List<Integer> item: tmp){
    			item.add(0, candidates[start]);
    			if(!result.contains(item)){
    				result.add(item);
    			}
    		}
    	}
    	return result;
    }
}