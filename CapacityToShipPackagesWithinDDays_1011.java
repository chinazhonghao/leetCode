class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int totalWeight = 0;
        int maxElement = 0;
        for(int i=0; i<weights.length; i++){
        	totalWeight += weights[i];
        	maxElement = Math.max(maxElement, weights[i]);
        }
        int average = (int)Math.ceil(totalWeight / D);
        int min = Math.max(average, maxElement);
        int count = (int)Math.ceil(weights.length / D);
        int max = 0;
        for(int i=0; i<count; i++){
        	max += totalWeight;
        }
        return _binarySearch(weights, min, max, D);
    }

    private int _binarySearch(int[] weights, int min, int max, int D){
    	if(min >= max){
    		return min;
    	}
    	int mid = (min + max) / 2;
    	int c = _isCapicity(weights, mid, D);
    	if(c < 0){
    		return _binarySearch(weights, mid+1, max, D);
    	}
    	else {
            return _binarySearch(weights, min, mid, D);
    	}
    }

    private int _isCapicity(int[] weights, int count, int D){
    	int tmp = 0;
        D--;
    	for(int i=0; i<weights.length; i++){
    		tmp += weights[i];
    		if(tmp > count){
    			D--;
    			tmp = weights[i];
    		}
    	}
    	return D;
    }
}