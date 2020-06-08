class Solution {
    private int[] nums;
    private Set<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(this.nums);
        result = new HashSet<>();
        result.add(new ArrayList<>());
        _recursive(0);
        List<List<Integer>> ll = new ArrayList<>();
        ll.addAll(result);
        return ll;
    }

    private void _recursive(int index){
        if(index >= nums.length){
            return ;
        }
        Iterator<List<Integer>> iter = result.iterator();
        List<List<Integer>> tmps = new ArrayList<>();
        while(iter.hasNext()){
            List<Integer> l = iter.next();
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(l);
            tmp.add(nums[index]);
            tmps.add(tmp);
        }
        for(int i=0; i<tmps.size(); i++){
            result.add(tmps.get(i));
        }
        _recursive(index+1);
    }
}