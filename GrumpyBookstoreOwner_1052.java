class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
    	int sum = 0;
    	for(int i=0; i<grumpy.length; i++){
    		if(grumpy[i] == 0){
    			sum += customers[i];
    		}
    	}

    	int maxSum = 0;
    	for(int i=0; i<grumpy.length; i++){
    		int s = sum;
    		for(int j=0; j<X; j++){
    			if(i+j >= grumpy.length){
    				break;
    			}
    			else if(grumpy[i+j] == 1){
    				s += customers[i+j];
    			}
    		}
    		if(s > maxSum){
    			maxSum = s;
    		}
    	}
    	return maxSum;
    }
}