class Solution {
    public int[][] merge(int[][] intervals) {
    	if(intervals.length == 0){
    		return intervals;
    	}
    	Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for(int[] item: intervals){
        	if(item[0] > right){
        		res.add(new int[]{left, right});
        		left = item[0];
        		right = item[1];
        	}
        	else if(item[1] > right) {
        		right = item[1];
        	}
        }
        res.add(new int[]{left, right});

        int[][] result = new int[res.size()][2];
        for(int i=0; i<res.size(); i++){
        	result[i] = res.get(i);
        }
        return result;
    }
}