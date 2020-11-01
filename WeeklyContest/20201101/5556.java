class Solution {
    private int currentMax = 0;
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int[] diff = new int[heights.length-1];
        for(int i=0; i<heights.length-1; i++){
            diff[i] = heights[i+1] - heights[i];
        }
        return _recursive(diff, bricks, ladders, 0);
    }

    private int _recursive(int[] diff, int bricks, int ladders, int index){
        if(currentMax == diff.length){
            return currentMax;
        }
        if(index == diff.length){
            currentMax = Math.max(currentMax, index);
            return index;
        }
        if(diff[index] <= 0 && currentMax < diff.length){
            int tmp = _recursive(diff, bricks, ladders, index+1);
            currentMax = Math.max(currentMax, tmp);
            return tmp;
        }
        if(ladders < 0 && diff[index] > bricks){
            currentMax = Math.max(currentMax, index);
            return index;
        }
        int index1 = index, index2 = index;
        if(diff[index] <= bricks && currentMax < diff.length){
            index1 = _recursive(diff, bricks-diff[index], ladders, index+1);
            currentMax = Math.max(currentMax, index1);
        }
        if(ladders > 0 && currentMax < diff.length){
            index2 = _recursive(diff, bricks, ladders-1, index+1);
            currentMax = Math.max(currentMax, index2);
        }
        return Math.max(index1, index2);
    }
}