class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return _combinationSum(k, n, 1);
    }

    public List<List<Integer>> _combinationSum(int k, int left, int base){
        List<List<Integer>> result = new ArrayList<>();
        if(left < base){
            return result;
        }
        if(k==1) {
            if(left < 10 && left >= base){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(left);
                result.add(tmp);
            }
            return result;
        }
        for(int i=base; i<10; i++){
            List<List<Integer>> _sub = _combinationSum(k-1, left-i, i+1);
            for(int j=0; j<_sub.size(); j++){
                _sub.get(j).add(i);
            }
            result.addAll(_sub);
        }
        return result;
    }
}