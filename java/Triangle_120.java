class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] cost = new int[triangle.size()+1];
        for(int i=triangle.size(); i>0; i--){
            for(int j=0; j<triangle.get(i-1).size(); j++){
                cost[j] = Math.min(cost[j], cost[j+1]) + triangle.get(i-1).get(j);
            }
        }
        return cost[0];
    }
}